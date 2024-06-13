package arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        
        int left = 0;
        int right  = 0;
        int result = 0;

        Map<Character, Integer> characterMap = new HashMap<>();
        while(right < s.length()) {
            characterMap.put(s.charAt(right), characterMap.getOrDefault(s.charAt(right), 0) + 1);
            if ((right-left)+1 - characterMap.values().stream().max(Integer::compare).get() <= k) {
                result = Math.max(result, (right-left)+1);
                right++;
            } else {
                characterMap.put(s.charAt(left), characterMap.get(s.charAt(left))-1);
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        System.out.println(longestRepeatingCharacterReplacement.characterReplacement("AABABBA", 1));
    }
}
