package backtracking.medium;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSum {

//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> tempResult = new ArrayList<>();
//        solve(result, tempResult, 0, candidates, target);
//        return result;
//    }
//
//    public void solve(List<List<Integer>> result, List<Integer> tempResult, int idx, int[] candidates, int target) {
//        if (target == 0) {
//            result.add(new ArrayList<>(tempResult));
//        } else if (target < 0 || idx >= candidates.length) {
//            return;
//        } else {
//            tempResult.add(candidates[idx]);
//            solve(result, tempResult, idx, candidates, target - candidates[idx]);
//
//            tempResult.remove(tempResult.size()-1);
//            solve(result, tempResult, idx+1, candidates, target);
//        }
//    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        combinationSum.combinationSum(new int[]{2,3,6,7}, 7).stream().map(innerList -> innerList.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ")))
                .forEach(System.out::println);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        dfs(result, current, 0, candidates, target);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> current, int idx, int[] candidates, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
        } else if (target < 0 || idx >= candidates.length) {
        } else {
            current.add(candidates[idx]);
            dfs(result, current, idx, candidates, target-candidates[idx]);
            current.remove(current.size()-1);
            dfs(result, current, idx+1, candidates, target);
        }
    }
}
