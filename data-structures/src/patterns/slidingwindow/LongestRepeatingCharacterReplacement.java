package patterns.slidingwindow;

import java.util.*;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int start = 0;
        int result = 0;
        int maxElement;

        Map<Character, Integer> map = new HashMap();
        for (int end=0; end<s.length(); end++) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0)+1);
            maxElement = map.get(s.charAt(end));
            if (end-start+1 - maxElement > k) {
                map.put(s.charAt(start), map.get(s.charAt(start))-1);
                start++;
            }
            result = Math.max(end-start+1, result);
        }

        return result;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement l = new LongestRepeatingCharacterReplacement();
        System.out.println(l.characterReplacement("AABABBA", 1));
    }
}
