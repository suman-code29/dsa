package backtracking.medium;

import java.util.*;
import java.util.stream.Collectors;

public class SubsetsII {
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> current = new ArrayList<>();
//        Arrays.sort(nums);
//        solve(result, current, 0, nums);
//        return result;
//    }
//
//    private void solve(List<List<Integer>> result, List<Integer> current, int idx, int[] nums) {
//        result.add(new ArrayList<>(current));
//        for (int i=idx; i<nums.length; i++) {
//            if (i>idx && nums[i] == nums[i-1]) continue;
//            current.add(nums[i]);
//            solve(result, current, i+1, nums);
//            current.remove(current.size()-1);
//        }
//    }
    public static void main(String[] args) {
        SubsetsII subsetsII = new SubsetsII();
        System.out.println(subsetsII.subsetsWithDup(new int[]{1,2,2}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        dfs(result,current, nums, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> current, int[] nums, int idx) {
        result.add(new ArrayList<>(current));
        for (int i=idx; i<nums.length ; i++) {
            if (i>idx && nums[i] == nums[i-1]) continue;
            current.add(nums[i]);
            dfs(result, current, nums, i+1);
            current.remove(current.size()-1);
        }
    }
}