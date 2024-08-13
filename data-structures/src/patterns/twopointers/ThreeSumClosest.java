package patterns.twopointers;

import java.util.*;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        for(int i=0; i<nums.length-2; i++) {
            int left = i+1;
            int right = nums.length-1;
            while(left < right) {
                int diff = target - nums[i] - nums[left] - nums[right];
                if (diff == 0) {
                    return target-diff;
                }

                if (Math.abs(diff) < Math.abs(result) || (Math.abs(diff) == Math.abs(result) && diff>result)) {
                    result = diff;
                }

                if (diff > 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return target - result;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        System.out.println(threeSumClosest.threeSumClosest(new int[]{-2,0,1,2}, 2));
        System.out.println(threeSumClosest.threeSumClosest(new int[]{-3,-1,1,2}, 1));
        System.out.println(threeSumClosest.threeSumClosest(new int[]{1,0,1,1}, 100));

    }
}
