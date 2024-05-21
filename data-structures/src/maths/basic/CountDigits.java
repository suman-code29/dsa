package maths.basic;

public class CountDigits {
    static int evenlyDivides(int N){
        int atomic = N;
        // code here
        int result = 0;
        while(N>0) {
            int value = N % 10;
            if ((value>0) && (atomic % value == 0)) {
                result++;
            }
            N = N/10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(evenlyDivides(22074));
    }
}
