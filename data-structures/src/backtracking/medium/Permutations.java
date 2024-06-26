package backtracking.medium;

import java.util.*;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current =  new ArrayList<>();

        boolean[] used = new boolean[nums.length];
        solve(result, current, nums, used);
        return result;
    }

    private void solve(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] used){
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
        }

        for (int i=0; i<nums.length; i++) {
            if (used[i]) continue;
            current.add(nums[i]);
            used[i] = true;

            solve(result, current, nums, used);
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permutations.permute(nums);
        System.out.println(result);
    }
}
