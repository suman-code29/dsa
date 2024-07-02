package backtracking.medium;

import java.util.*;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[n];
        for(int i=0; i<n ; i++) {
            arr[i] = i+1;
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        dfs(result, current, 0, k, arr);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> current, int idx, int target, int[] arr) {
        if (current.size() == target && idx <= arr.length) {
            result.add(new ArrayList<>(current));
            return;
        } else if (idx >= arr.length) {
            return;
        }

        current.add(arr[idx]);
        dfs(result, current, idx+1, target, arr);

        current.remove(current.size()-1);
        dfs(result, current, idx+1, target, arr);
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4, 2));
    }
}
