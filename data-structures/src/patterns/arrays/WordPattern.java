package patterns.arrays;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] strs = s.split(" ");
        if (strs.length != pattern.length()) return false;
        for(int i=0; i<strs.length; i++) {
            if(!map.containsKey(pattern.charAt(i)) && !map.containsValue(strs[i])) {
                map.put(pattern.charAt(i), strs[i]);
            } else {
                if (!map.containsKey(pattern.charAt(i)) && map.containsValue(strs[i])) {
                    return false;
                }
                if (!map.get(pattern.charAt(i)).equals(strs[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern("abba", "dog dog dog dog"));
    }
}
