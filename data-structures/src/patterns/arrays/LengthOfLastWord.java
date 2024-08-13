package patterns.arrays;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int n = s.length();
        int result = 0;
        int i=n-1;
        while(i >= 0 && s.charAt(i) != ' ') {
            result++;
            i++;
        }
        return result;
    }
}
