package maths.basic;

public class PalindromeNumber {

//    public boolean isPalindrome(int x) {
//        String value = Integer.toString(x);
//        int i=0;
//        int j=value.length()-1;
//
//        while(j>=i) {
//            if (value.charAt(i) != value.charAt(j)) {
//                return false;
//            }
//            i++;
//            j--;
//        }
//
//        return true;
//    }

    // This is without converting the number into string
    public boolean isPalindrome(int x) {
        int duplicate = x;
        int reverse = 0;

        while(x > 0) {
            int lastDigit = x % 10;
            x = x/10;

            reverse = (reverse * 10) + lastDigit;
        }
        return reverse == duplicate;
    }
    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(1214));
    }
}
