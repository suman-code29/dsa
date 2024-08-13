package patterns.arrays.medium;

import java.util.*;

public class UniqueLength_3PalindromicSubsequences {
//    public int countPalindromicSubsequence(String s) {
//        Set<String> res = new HashSet<>();
//        Map<Character, List<Integer>> characterListMap = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (!characterListMap.containsKey(c)) {
//                characterListMap.put(c, new ArrayList<>());
//            }
//            characterListMap.get(c).add(i);
//        }
//
//        for (Character key : characterListMap.keySet()) {
//            List<Integer> positions = characterListMap.get(key);
//            if (positions.size() > 1) {
//                int first = positions.get(0);
//                int last = positions.get(positions.size() - 1);
//                for (int i = first + 1; i < last; i++) {
//                    res.add("" + key + s.charAt(i) + key);
//                }
//            }
//        }
//
//        return res.size();
//    }

    public int countPalindromicSubsequence(String s) {
        int n = s.length();

        Set<Character> letters = new HashSet<>();
        for(int i=0; i<n; i++) {
            letters.add(s.charAt(i));
        }

        int result = 0;

        for (Character chr : letters) {
            int left = -1;
            int right = -1;

            for(int i=0; i<n;i++) {
                if (s.charAt(i) == chr) {
                    if(left == -1) {
                        left = i;
                    }
                    right = i;
                }
            }
            Set<Character> st = new HashSet<>();
            for(int middle = left+1; middle<=right-1; middle++) {
                st.add(s.charAt(middle));
            }

            result += st.size();
        }
        return result;
    }


    public static void main(String[] args) {
        UniqueLength_3PalindromicSubsequences u = new UniqueLength_3PalindromicSubsequences();
        System.out.println(u.countPalindromicSubsequence("bbcbaba"));
    }
}
