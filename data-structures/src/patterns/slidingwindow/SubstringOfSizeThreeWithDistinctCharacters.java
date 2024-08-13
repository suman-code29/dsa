package patterns.slidingwindow;

import java.util.*;

public class SubstringOfSizeThreeWithDistinctCharacters {
    public int countGoodSubstrings(String s) {
        if (s.length() < 3) {
            return 0;
        }
        int result = 0;

        for(int i=0; i<s.length()-2; i++) {
            if (s.charAt(i) != s.charAt(i+1) && s.charAt(i) != s.charAt(i+2) && s.charAt(i+1) != s.charAt(i+2)) {
                result++;
            }
        }

        return result;
    }
}
