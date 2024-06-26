
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.Vector;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.AfterClass;
import org.junit.Test;

public class EmployeeTest {
    static class EmployeeRepository {
        private List<Employee> empList;

        public EmployeeRepository(List<Employee> empList) {
            this.empList = empList;

        }
        public Employee findById(Integer id) {
            for (Employee emp : empList) {
                if (emp.getId() == id) {
                    return emp;
                }
            }

            return null;
        }
    }

    static class Employee {
        private Integer id;
        private String name;
        private Double salary;

        public Employee(Integer id, String name, Double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

        public void salaryIncrement(Double percentage) {
            Double newSalary = salary + percentage * salary / 100;
            setSalary(newSalary);
        }

        public String toString() {
            return "Id: " + id + " Name:" + name + " Price:" + salary;
        }
    }

    private static String fileName = "src/test/resources/test.txt";

    private static Employee[] arrayOfEmps = {
            new Employee(1, "Jeff Bezos", 100000.0),
            new Employee(2, "Bill Gates", 200000.0),
            new Employee(3, "Mark Zuckerberg", 300000.0)
    };

    private static List<Employee> empList = Arrays.asList(arrayOfEmps);
    private static EmployeeRepository employeeRepository = new EmployeeRepository(empList);

    @AfterClass
    public static void cleanup() throws IOException {
        Files.deleteIfExists(Paths.get(fileName));
    }

    @Test
    public void whenGetStreamFromList_ObtainStream() {
        assert(empList.stream() instanceof Stream<?>);
    }

    @Test
    public void whenGetStreamFromArray_ObtainStream() {
        assert(Stream.of(arrayOfEmps) instanceof Stream<?>);
    }

    @Test
    public void whenGetStreamFromElements_ObtainStream() {
        assert(Stream.of(arrayOfEmps[0], arrayOfEmps[1], arrayOfEmps[2]) instanceof Stream<?>);
    }

    @Test
    public void whenBuildStreamFromElements_ObtainStream() {
        Stream.Builder<Employee> empStreamBuilder = Stream.builder();

        empStreamBuilder.accept(arrayOfEmps[0]);
        empStreamBuilder.accept(arrayOfEmps[1]);
        empStreamBuilder.accept(arrayOfEmps[2]);

        Stream<Employee> empStream = empStreamBuilder.build();

        assert(empStream instanceof Stream<?>);
    }

    @Test
    public void whenIncrementSalaryForEachEmployee_thenApplyNewSalary() {
        Employee[] arrayOfEmps = {
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000.0)
        };

        List<Employee> empList = Arrays.asList(arrayOfEmps);

        empList.stream().forEach(e -> e.salaryIncrement(10.0));

    }

    @Test
    public void whenIncrementSalaryUsingPeek_thenApplyNewSalary() {
        Employee[] arrayOfEmps = {
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000.0)
        };

        List<Employee> empList = Arrays.asList(arrayOfEmps);

        empList.stream()
                .peek(e -> e.salaryIncrement(10.0))
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    @Test
    public void whenMapIdToEmployees_thenGetEmployeeStream() {
        Integer[] empIds = { 1, 2, 3 };

        List<Employee> employees = Stream.of(empIds)
                .map(employeeRepository::findById)
                .collect(Collectors.toList());

            }

    @Test
    public void whenFlatMapEmployeeNames_thenGetNameStream() {
        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Jeff", "Bezos"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg"));

        List<String> namesFlatStream = namesNested.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

            }

    @Test
    public void whenFilterEmployees_thenGetFilteredStream() {
        Integer[] empIds = { 1, 2, 3, 4 };

        List<Employee> employees = Stream.of(empIds)
                .map(employeeRepository::findById)
                .filter(e -> e != null)
                .filter(e -> e.getSalary() > 200000)
                .collect(Collectors.toList());

            }

    @Test
    public void whenFindFirst_thenGetFirstEmployeeInStream() {
        Integer[] empIds = { 1, 2, 3, 4 };

        Employee employee = Stream.of(empIds)
                .map(employeeRepository::findById)
                .filter(e -> e != null)
                .filter(e -> e.getSalary() > 100000)
                .findFirst()
                .orElse(null);

            }

    @Test
    public void whenCollectStreamToList_thenGetList() {
        List<Employee> employees = empList.stream().collect(Collectors.toList());

            }

    @Test
    public void whenStreamToArray_thenGetArray() {
        Employee[] employees = empList.stream().toArray(Employee[]::new);

        assertThat(empList.toArray(), equalTo(employees));
    }

    @Test
    public void whenStreamCount_thenGetElementCount() {
        Long empCount = empList.stream()
                .filter(e -> e.getSalary() > 200000)
                .count();

            }

    @Test
    public void whenLimitInfiniteStream_thenGetFiniteElements() {
        Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);

        List<Integer> collect = infiniteStream
                .skip(3)
                .limit(5)
                .collect(Collectors.toList());

            }

    @Test
    public void whenSortStream_thenGetSortedStream() {
        List<Employee> employees = empList.stream()
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                .collect(Collectors.toList());

                            }


    @Test
    public void whenFindMin_thenGetMinElementFromStream() {
        Employee firstEmp = empList.stream()
                .min((e1, e2) -> e1.getId() - e2.getId())
                .orElseThrow(NoSuchElementException::new);

            }

    @Test
    public void whenFindMax_thenGetMaxElementFromStream() {
        Employee maxSalEmp = empList.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);

            }

    @Test
    public void whenApplyDistinct_thenRemoveDuplicatesFromStream() {
        List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 3);
        List<Integer> distinctIntList = intList.stream().distinct().collect(Collectors.toList());

            }

    @Test
    public void whenApplyMatch_thenReturnBoolean() {
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);

        boolean allEven = intList.stream().allMatch(i -> i % 2 == 0);
        boolean oneEven = intList.stream().anyMatch(i -> i % 2 == 0);
        boolean noneMultipleOfThree = intList.stream().noneMatch(i -> i % 3 == 0);

                            }

    @Test
    public void whenFindMaxOnIntStream_thenGetMaxInteger() {
        Integer latestEmpId = empList.stream()
                .mapToInt(Employee::getId)
                .max()
                .orElseThrow(NoSuchElementException::new);

            }

    @Test
    public void whenApplySumOnIntStream_thenGetSum() {
        Double avgSal = empList.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElseThrow(NoSuchElementException::new);

            }

    @Test
    public void whenApplyReduceOnStream_thenGetValue() {
        Double sumSal = empList.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);

            }

    @Test
    public void whenCollectByJoining_thenGetJoinedString() {
        String empNames = empList.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "))
                .toString();

            }

    @Test
    public void whenCollectBySet_thenGetSet() {
        Set<String> empNames = empList.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());

            }

    @Test
    public void whenToVectorCollection_thenGetVector() {
        Vector<String> empNames = empList.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(Vector::new));

            }

    @Test
    public void whenApplySummarizing_thenGetBasicStats() {
        DoubleSummaryStatistics stats = empList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));

                                            }

    @Test
    public void whenApplySummaryStatistics_thenGetBasicStats() {
        DoubleSummaryStatistics stats = empList.stream()
                .mapToDouble(Employee::getSalary)
                .summaryStatistics();

                                            }

    @Test
    public void whenStreamPartition_thenGetMap() {
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
        Map<Boolean, List<Integer>> isEven = intList.stream().collect(
                Collectors.partitioningBy(i -> i % 2 == 0));

                    }

    @Test
    public void whenStreamReducing_thenGetValue() {
        Double percentage = 10.0;
        Double salIncrOverhead = empList.stream().collect(Collectors.reducing(
                0.0, e -> e.getSalary() * percentage / 100, (s1, s2) -> s1 + s2));

            }

    @Test
    public void whenParallelStream_thenPerformOperationsInParallel() {
        Employee[] arrayOfEmps = {
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000.0)
        };

        List<Employee> empList = Arrays.asList(arrayOfEmps);

        empList.stream().parallel().forEach(e -> e.salaryIncrement(10.0));
    }

    @Test
    public void whenGenerateStream_thenGetInfiniteStream() {
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }

    @Test
    public void whenIterateStream_thenGetInfiniteStream() {
        Stream<Integer> evenNumStream = Stream.iterate(2, i -> i * 2);

        List<Integer> collect = evenNumStream
                .limit(5)
                .collect(Collectors.toList());

            }

    @Test
    public void whenStreamToFile_thenGetFile() throws IOException {
        String[] words = {
                "hello",
                "refer",
                "world",
                "level"
        };

        try (PrintWriter pw = new PrintWriter(
                Files.newBufferedWriter(Paths.get(fileName)))) {
            Stream.of(words).forEach(pw::println);
        }
    }

    private List<String> getPalindrome(Stream<String> stream, int length) {
        return stream.filter(s -> s.length() == length)
                .filter(s -> s.compareToIgnoreCase(
                        new StringBuilder(s).reverse().toString()) == 0)
                .collect(Collectors.toList());
    }

    @Test
    public void whenFileToStream_thenGetStream() throws IOException {
        whenStreamToFile_thenGetFile();

        List<String> str = getPalindrome(Files.lines(Paths.get(fileName)), 5);
    }
}
