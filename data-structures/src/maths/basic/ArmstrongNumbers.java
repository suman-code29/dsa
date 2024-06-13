package maths.basic;

public class ArmstrongNumbers {
    static String armstrongNumber(int n){
        int duplicate = n;
        int result = 0;

        while(n > 0) {
            int lastDigit = n % 10;
            n = n/10;
            result = result + (lastDigit*lastDigit*lastDigit);
        }

        return duplicate == result ? "Yes" : "No";
    }

    public static void main(String[] args) {
        System.out.println(armstrongNumber(153));
    }
}
