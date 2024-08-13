package patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubString {
    public int findLength(String s) {

        int longestSubsing = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
            while (map.get(s.charAt(i)) > 1) {
                map.put(s.charAt(start), map.get(s.charAt(start))-1);
                if (map.get(s.charAt(start)) == 0) {
                    map.remove(s.charAt(start));
                }
                start++;
            }
            longestSubsing = Math.max(longestSubsing, i-start+1);
        }

        return longestSubsing;
    }

    public int findLengthWithoutWhileLoop(String s) {
        int longestSubsing = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(start, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            longestSubsing = Math.max(longestSubsing, i-start+1);
        }

        return longestSubsing;
    }

    public static void main(String [] args) {
        NoRepeatSubString noRepeatSubstring = new NoRepeatSubString();
        System.out.println(noRepeatSubstring.findLength("aabccbb"));
        System.out.println(noRepeatSubstring.findLength("abbbb"));
        System.out.println(noRepeatSubstring.findLength("abccde"));
    }
}
