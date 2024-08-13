package patterns.slidingwindow;

import java.util.*;

public class StringPermutation {
    public static boolean findPermutation(String s2, String s1) {
        int start = 0;
        int matched = 0;
        Map<Character, Integer> patternMap = new HashMap<>();
        for(char chr : s1.toCharArray()) {
            patternMap.put(chr, patternMap.getOrDefault(chr, 0)+1);
        }

        for(int i=0; i<s2.length(); i++) {
            if (patternMap.containsKey(s2.charAt(i))) {
                patternMap.put(s2.charAt(i), patternMap.get(s2.charAt(i))-1);
                if (patternMap.get(s2.charAt(i)) == 0) {
                    matched++;
                }
            }

            if (matched == patternMap.size()) {
                return true;
            }

            if (i >= s1.length()-1) {
                char leftChar = s2.charAt(start++);
                if (patternMap.containsKey(leftChar)) {
                    if (patternMap.get(leftChar) == 0) {
                        matched--;
                    }
                    patternMap.put(leftChar, patternMap.get(leftChar)+1);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(findPermutation("eidbaooo", "ab"));
    }
}
