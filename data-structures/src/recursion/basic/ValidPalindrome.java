package recursion.basic;

import java.util.Locale;

public class ValidPalindrome {

//    public boolean isPalindrome(String s) {
//        s = s.toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9]", "");
//        int i = 0;
//        int j = s.length()-1;
//        if (i >= (j+1)/2) {
//            return true;
//        }
//        if (s.charAt(i) != s.charAt(j)) {
//            return false;
//        }
//        return isPalindrome(s.substring(i+1, j));
//    }
public boolean check(int i, String s) {
    // Base Condition
    // If i exceeds half of the string, means all the elements
    // are compared, we return true.
    if(i>=s.length()/2) return true;

    // If start is not equal to end, not palindrome.
    if(s.charAt(i)!=s.charAt(s.length()-i-1)) return false;

    // If both characters are same, increment i and check start+1 and end-1.
    return check(i+1,s);
}

    public boolean isPalindrome(String s) {
        s = s.toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9]", "");
        return check(0, s);
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome(" "));
    }
}
