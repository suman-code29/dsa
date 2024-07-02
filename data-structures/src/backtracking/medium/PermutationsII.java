package backtracking.medium;

import java.util.*;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(result, current, used, nums);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> current, boolean[] used, int[] nums) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
        }

        for (int i=0; i<nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
            if (used[i]) continue;
            current.add(nums[i]);
            used[i]=true;

            dfs(result, current, used, nums);
            used[i]=false;
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {
        PermutationsII permutations = new PermutationsII();
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = permutations.permuteUnique(nums);
        System.out.println(result);
    }
}
