package backtracking.medium;

import java.util.*;
import java.util.stream.Collectors;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        solve(result, current, 0, nums);
        List<List<Integer>> sortedLists = result.stream()
                .map(innerList -> {
                    List<Integer> sortedList = new ArrayList<>(innerList);
                    Collections.sort(sortedList);
                    return sortedList;
                })
                .toList();

        Set<List<Integer>> uniqueSortedLists = new HashSet<>(sortedLists);

        return new ArrayList<>(uniqueSortedLists);
    }

    private void solve(List<List<Integer>> result, List<Integer> current, int idx, int[] nums) {
        if (idx >= nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[idx]);
        solve(result, current, idx+1, nums);

        current.remove(current.size()-1);
        solve(result, current, idx+1, nums);
    }

    public static void main(String[] args) {
        SubsetsII subsetsII = new SubsetsII();
        System.out.println(subsetsII.subsetsWithDup(new int[]{4,4,4,1,4}));
    }
}