package patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfOccurancesOfASubstring {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int start = 0;
        Map<String, Integer> strMap = new HashMap<>();
        Map<Character, Integer> charMap = new HashMap<>();
        int result = 0;

        for(int end = 0; end<s.length(); end++) {
            charMap.put(s.charAt(end), charMap.getOrDefault(s.charAt(end), 0)+1);
            if (end - start+1 > minSize-1) {
                if (charMap.keySet().size() <= maxLetters) {
                    String temp = s.substring(start, end+1);
                    strMap.put(temp, strMap.getOrDefault(temp, 0)+1);
                    result = Math.max(strMap.get(temp), result);
                }
                charMap.put(s.charAt(start), charMap.get(s.charAt(start))-1);
                if (charMap.get(s.charAt(start)) == 0) {
                    charMap.remove(s.charAt(start));
                }
                start++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumNumberOfOccurancesOfASubstring m = new MaximumNumberOfOccurancesOfASubstring();
        System.out.println(m.maxFreq("aababcaab", 2, 3, 4));
    }



}
