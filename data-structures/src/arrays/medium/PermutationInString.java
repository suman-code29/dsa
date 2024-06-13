package arrays.medium;

import java.util.Arrays;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        
        int[] s1freq = new int[26];
        int[] s2freq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1freq[s1.charAt(i)-'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            s2freq[s2.charAt(i)-'a']++;
            if (i >= s1.length()) {
                s2freq[s2.charAt(i-s1.length())-'a']--;
            }
            if (Arrays.equals(s1freq, s2freq)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PermutationInString permutationInString = new PermutationInString();
        System.out.println(permutationInString.checkInclusion("ab", "eidbaooo"));
    }
}
