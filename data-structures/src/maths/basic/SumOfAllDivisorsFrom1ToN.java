package maths.basic;

public class SumOfAllDivisorsFrom1ToN {

//    // optimised solution
//    static long sumOfDivisors(int N) {
//        long res = 0;
//        for(int i=1; i<=N; i++) {
//            res += (N/i)*i;
//        }
//        return res;
//    }
    static long sumOfDivisors(int N) {
        long res = 0;
        for(int i=0; i<=N; i++) {
            res = res + result(i);
        }
        return res;
    }
    static long result(int N) {
        long result = 0;
        int i = 1;
        while (i <= N) {
            if (N % i == 0) {
                result = result + i;
            }
            i++;
        }
        return result;
    }

    static void printAllDivisors(int N) {
        int i = 1;
        while (i <= N) {
            if (N % i == 0) {
                System.out.println(i);
            }
            i++;
        }
    }

    public static void main(String[] args) {
        System.out.println(sumOfDivisors(4));
    }
}
