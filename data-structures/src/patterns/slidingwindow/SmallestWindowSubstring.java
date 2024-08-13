package patterns.slidingwindow;

import java.util.*;

public class SmallestWindowSubstring {
    public String minWindow(String s, String t) {
        int windowStart = 0;
        int matched = 0;
        int minLength = s.length()+1;
        int subStringStart = 0;

        Map<Character, Integer> map = new HashMap<>();
        for(char chr : t.toCharArray()) {
            map.put(chr, map.getOrDefault(chr, 0) + 1);
        }

        for (int i=0; i<s.length(); i++) {
            char rightChar = s.charAt(i);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar)-1);
                if (map.get(rightChar) >= 0) {
                    matched++;
                }
            }

            while(matched == t.length()) {
                if (minLength > i-windowStart+1) {
                    minLength = i-windowStart+1;
                    subStringStart = windowStart;
                }

                char leftChar = s.charAt(windowStart++);
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0) {
                        matched--;
                    }

                    map.put(leftChar, map.get(leftChar)+1);
                }
            }
        }

        return minLength > s.length() ? "" : s.substring(subStringStart, subStringStart+minLength);
    }

    public static void main(String[] args) {
        SmallestWindowSubstring s = new SmallestWindowSubstring();
        System.out.println(s.minWindow("ADOBECODEBANC", "ABC"));
    }
}
