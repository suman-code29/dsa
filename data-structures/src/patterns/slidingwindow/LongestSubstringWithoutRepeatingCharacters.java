package patterns.slidingwindow;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int start = 0;

        Set<Character> charSet = new HashSet<>();
        for(int end = 0; end<s.length(); end++) {
            if (charSet.contains(s.charAt(end))) {
                while(charSet.contains(s.charAt(end))) {
                    charSet.remove(s.charAt(start));
                    start++;
                }
            }
            charSet.add(s.charAt(end));
            result = Math.max(result, end - start + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring(" "));
    }
}
