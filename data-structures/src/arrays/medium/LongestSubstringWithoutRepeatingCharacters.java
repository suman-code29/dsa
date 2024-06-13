package arrays.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        Set<Character> charSet = new HashSet<>();
        int result = 0;

        while(right < s.length()){
            if (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            } else {
                charSet.add(s.charAt(right));
                result = Math.max(result, right-left + 1);
                right++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb"));
    }
}
