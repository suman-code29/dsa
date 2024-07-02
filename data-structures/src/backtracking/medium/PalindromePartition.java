package backtracking.medium;

import java.util.*;

public class PalindromePartition {
//    public List<List<String>> partition(String s) {
//        List<List<String>> res = new ArrayList<List<String>>();
//        if (s.equals("")) {
//            res.add(new ArrayList<String>());
//            return res;
//        }
//        for (int i = 0; i < s.length(); i++) {
//            if (isPalindrome(s, i + 1)) {
//                for (List<String> list : partition(s.substring(i + 1))) {
//                    list.add(0, s.substring(0, i + 1));
//                    res.add(list);
//                }
//            }
//        }
//        return res;
//    }
//
//    public boolean isPalindrome(String s, int n) {
//        for (int i = 0; i < n / 2; i++) {
//            if (s.charAt(i) != s.charAt(n - i - 1)) return false;
//        }
//        return true;
//    }

    public static void main(String[] args) {
        PalindromePartition palindromePartition = new PalindromePartition();
        System.out.println(palindromePartition.partition("aab"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();

        dfs(result, current, s, 0);
        return result;
    }

    private void dfs(List<List<String>> result, List<String> current, String s, int idx) {
        if (idx >= s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i=idx; i<s.length(); i++) {
            if (isPalindrome(s.substring(idx, i+1))) {
                current.add(s.substring(idx, i+1));
                dfs(result, current, s, i + 1);
                current.remove(current.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }

}
