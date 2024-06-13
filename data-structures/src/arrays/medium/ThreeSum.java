package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> outerList = new ArrayList<>();
        Arrays.sort(nums);

        for (int x = 0; x<nums.length-2 ; x++) {
            int i = 1;
            int j = nums.length-1;
            List<Integer> innerResult = new ArrayList<>();
            while(i<j) {
                if (nums[i] + nums[j] + nums[x] == 0) {
                    innerResult.add(nums[x]);
                    innerResult.add(nums[i]);
                    innerResult.add(nums[j]);
                } else if (nums[i] + nums[j] + nums[x] > 0) {
                    j--;
                } else {
                    i++;
                }
            }
            outerList.add(innerResult);
        }
        return outerList;
    }
}
