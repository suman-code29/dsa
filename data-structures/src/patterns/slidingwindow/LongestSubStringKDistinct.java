package patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringKDistinct {
    public int findLength(String str, int k) {
        int longestSubString = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
            while(map.keySet().size() > k) {
                map.put(str.charAt(start), map.get(str.charAt(start))-1);
                if (map.get(str.charAt(start)) == 0) {
                    map.remove(str.charAt(start));
                }
                start++;
            }
            longestSubString = Math.max(longestSubString, i-start+1);
        }

        return longestSubString;
    }

    public static void main(String[] args) {
        LongestSubStringKDistinct longestSubStringKDistinct = new LongestSubStringKDistinct();
        System.out.println(longestSubStringKDistinct.findLength("araaci", 2));
    }
}
