package backtracking.medium;

import java.util.*;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        dfs(result, s, 0, "", 0);
        return result;
    }

    private void dfs(List<String> result, String s, int idx, String current, int parts) {
        if (idx == s.length() && parts == 4) {
            result.add(current.substring(0, current.length()-1));
            return;
        }
        if (parts >= 4) {
            return;
        }
        if (idx + 1 <= s.length()) {
            dfs(result, s, idx+1, current + s.charAt(idx) + '.', parts+1);
        }
        if (idx + 2 <= s.length() && isValid(s.substring(idx, idx+2))) {
            dfs(result, s, idx+2, current + s.substring(idx, idx + 2) + '.', parts+1);
        }
        if (idx + 3 <= s.length() && isValid(s.substring(idx, idx+3))) {
            dfs(result, s, idx+3, current + s.substring(idx, idx + 3) + '.', parts+1);
        }
    }

    public boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }

    public static void main(String[] args) {
        RestoreIPAddresses solution = new RestoreIPAddresses();
        System.out.println(solution.restoreIpAddresses("25525511135"));
    }
}
