package patterns.slidingwindow;

import java.util.*;

public class StringAnagrams {
    public static List<Integer> findStringAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int matched = 0;
        Map<Character, Integer> patternMap = new HashMap<>();
        for(char chr : p.toCharArray()) {
            patternMap.put(chr, patternMap.getOrDefault(chr, 0) + 1);
        }


        for(int i=0; i<s.length(); i++) {
            char rightChar = s.charAt(i);
            if (patternMap.containsKey(rightChar)) {
                patternMap.put(rightChar, patternMap.get(rightChar)-1);
                if (patternMap.get(rightChar) == 0) {
                    matched++;
                }
            }

            if (matched == patternMap.size()) {
                result.add(start);
            }

            if (i>=p.length()-1){
                char leftChar = s.charAt(start++);
                if (patternMap.containsKey(leftChar)) {
                    if (patternMap.get(leftChar) == 0) {
                        matched--;
                    }
                    patternMap.put(leftChar, patternMap.get(leftChar) + 1);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(StringAnagrams.findStringAnagrams("cbaebabacd", "abc"));
    }
}