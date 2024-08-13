package patterns.arrays;

import java.util.*;

public class MaximumProductDifferenceBetweenTwoPairs {

    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int result = 0;

        if(nums[0] != nums[1] && nums[nums.length-1] != nums[nums.length-2]) {
            result = (nums[nums.length-1] * nums[nums.length-2]) - (nums[0]*nums[1]);
        }
        return result;
    }
}
