package patterns.arrays;

import java.util.*;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> result = new HashMap<>();
        int i = 0;

        while(i<s.length()) {
            if(result.get(s.charAt(i)) != null) {
                if (result.get(s.charAt(i)) != t.charAt(i)) return false;
            } else {
                if (result.containsValue(t.charAt(i))) return false;
            }
            result.put(s.charAt(i), t.charAt(i));
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        System.out.println(isomorphicStrings.isIsomorphic("ab", "ab"));
    }
}
