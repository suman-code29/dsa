package patterns.slidingwindow;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        if (s.isEmpty() || k==0) {
            return 0;
        }
        Set<Character> charSet = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        int start = 0;
        int vowelCount = 0;
        int result = 0;

        for (int end = 0; end<s.length(); end++) {
            if (charSet.contains(s.charAt(end))) {
                vowelCount++;
            }
            if (end -start+1 > k-1) {
                result = Math.max(vowelCount, result);
                if (charSet.contains(s.charAt(start))) {
                    vowelCount--;
                }
                start++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumNumberOfVowelsInASubstringOfGivenLength m = new MaximumNumberOfVowelsInASubstringOfGivenLength();
        System.out.println(m.maxVowels("leetcode", 3));
    }
}
