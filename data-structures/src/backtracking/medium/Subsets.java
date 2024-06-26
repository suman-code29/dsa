package backtracking.medium;

import java.util.*;
import java.util.stream.Collectors;

public class Subsets {
    List<Integer> tempResult = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        return solve(0, nums);
    }

    private List<List<Integer>> solve(int idx, int[] nums) {

        if (idx >= nums.length) {
            result.add(new ArrayList<>(tempResult));
            return result;
        }
        tempResult.add(nums[idx]);
        solve(idx+1, nums);

        tempResult.remove(tempResult.size() - 1);
        solve(idx+1, nums);

        return result;
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
         subsets.subsets(new int[]{1,2,3}).stream().map(innerList -> innerList.stream()
                         .map(String::valueOf)
                         .collect(Collectors.joining(", ")))
                 .forEach(System.out::println);

    }
}
