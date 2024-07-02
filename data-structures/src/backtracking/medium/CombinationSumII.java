package backtracking.medium;

import java.util.*;

public class CombinationSumII {
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> current =  new ArrayList<>();
//        Arrays.sort(candidates);
//        solve(result, 0, current, target, candidates);
//        return result;
//    }
//
//    private void solve(List<List<Integer>> result, int idx, List<Integer> current, int target, int[] candidates) {
//        if (target == 0) {
//            result.add(new ArrayList<>(current));
//            return;
//        } else if (target < 0 || idx >= candidates.length) {
//            return;
//        }
//        for (int i=idx; i<candidates.length; i++) {
//            if (i > idx && candidates[i] == candidates[i-1]) continue;
//            current.add(candidates[i]);
//            solve(result, i+1, current, target-candidates[i], candidates);
//
//            current.remove(current.size()-1);
////            solve(result, i+1, current, target, candidates);
//        }
//    }

    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();
        System.out.println(combinationSumII.combinationSum2(new int[]{2,5,2,1,2}, 5));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current =  new ArrayList<>();
        Arrays.sort(candidates);
        dfs(result, 0, current, target, candidates);
        return result;
    }

    private void dfs(List<List<Integer>> result, int idx, List<Integer> current, int target, int[] candidates) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        } else if (target < 0 || idx >= candidates.length) {
            return;
        }
        for (int i=idx; i<candidates.length; i++) {
            if (i>idx && candidates[i] == candidates[i-1]) continue;
            current.add(candidates[i]);
            dfs(result, i+1, current, target-candidates[i], candidates);
            current.remove(current.size()-1);
        }
    }
}
