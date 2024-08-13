package patterns.slidingwindow;

import java.util.*;

public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        int start = 0;
        int maxSum = 0;
        int temp = 0;

        Set<Integer> intset = new HashSet<>();
        for (int num : nums) {
            while (intset.contains(num)) {
                maxSum = Math.max(temp, maxSum);
                temp -= nums[start];
                intset.remove(nums[start]);
                start++;
            }
            temp += num;
            intset.add(num);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaximumErasureValue m = new MaximumErasureValue();
        System.out.println(m.maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
    }
}
