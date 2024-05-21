package twopointers;

public class IsPalindrome {
    public boolean isPalindrome(String s) {

        if (s.isEmpty()) {
            return true;
        }
        char[] ch = s.toLowerCase().toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for(char c : ch) {
            if (Character.isLetterOrDigit(c)) {
                stringBuilder.append(c);
            }
        }

        char[] finalCh = stringBuilder.toString().toCharArray();
        int i = 0;
        int j = finalCh.length-1;
        while (i<j) {
            if (finalCh[i]!=finalCh[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        IsPalindrome isPalindrome = new IsPalindrome();
        isPalindrome.isPalindrome(s);
    }
}
