package backtracking.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class SumOfAllSubsetXORTotals {

    public int subsetXORSum(int[] nums) {
        AtomicInteger result = new AtomicInteger(0);
        List<Integer> current = new ArrayList<>();
        dfs(result, current, 0, nums);
        return result.get();
    }


    private void dfs(AtomicInteger result, List<Integer> current,int idx, int[] nums) {
        if (idx >= nums.length) {
            result.addAndGet(current.stream().reduce(0, (a, b) -> a ^ b));
            return;
        }

        current.add(nums[idx]);
        dfs(result, current, idx+1, nums);

        current.remove(current.size()-1);
        dfs(result, current, idx+1, nums);
    }

    public static void main(String[] args) {
        SumOfAllSubsetXORTotals sumOfAllSubsetXORTotals = new SumOfAllSubsetXORTotals();
        System.out.println(sumOfAllSubsetXORTotals.subsetXORSum(new int[]{1,3}));
    }
}
