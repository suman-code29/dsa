package patterns.slidingwindow;

import java.util.*;

public class LongestSubstringWithSameLettersAfterReplacement {
    public int findLength(String str, int k) {
        int maxLength = 0;
        int start = 0;
        int maxRepeatElementCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
            maxRepeatElementCount = Math.max(maxRepeatElementCount, map.get(str.charAt(i)));

            if (i-start+1 - maxRepeatElementCount > k) {
                map.put(str.charAt(start), map.get(str.charAt(start)) - 1);
                start++;
            }
            maxLength = Math.max(maxLength, i-start+1);
        }
        return maxLength;
    }

    public int characterReplacement(String s, int k) {
        if (s.isEmpty()) {
            return 0;
        }

        int result = 0;
        int start = 0;
        int maxRepeatingElementCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
            maxRepeatingElementCount = Math.max(maxRepeatingElementCount, map.get(s.charAt(i)));
            if (i-start+1-maxRepeatingElementCount > k) {
                map.put(s.charAt(start), map.get(s.charAt(i))-1);
                start++;
            }
            result = Math.max(result, i-start+1);
        }

        return result;
    }

    public static void main(String[] args) {
        LongestSubstringWithSameLettersAfterReplacement l = new LongestSubstringWithSameLettersAfterReplacement();
        System.out.println(l.findLength("aabccbb", 2));
    }
}
