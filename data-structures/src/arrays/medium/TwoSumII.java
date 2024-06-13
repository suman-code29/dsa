package arrays.medium;

class TwoSumII {
    // public static int[] twoSum(int[] numbers, int target) {
    //     int[] result = new int[2];
    //     int i=0;
    //     int j=i+1;
    //     boolean completed = false;

    //     while(i < numbers.length) {
    //         while(j < numbers.length) {
    //             if (((numbers[i] + numbers[j]) == target) && i != j) {
    //                 result[0] = i+1;
    //                 result[1] = j+1;
    //                 completed = true;
    //                 break;
    //             }
    //             j++;
    //         }
    //         if (completed) return result;
    //         i++;
    //         j = i+1;
    //     }
    //     return result;
    // }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i=0;
        int j=numbers.length-1;

        while(i<j) {
            int sol = numbers[i] + numbers[j];
            if (sol == target) {
                result[0] = i+1;
                result[1] = j+1;
                break;
            } else if (sol > target) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {5,25,75};
        int target = 100;
        int[] result = twoSum(numbers, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}

