package patterns.twopointers;

import java.util.*;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int result = 0;
        double product = 1;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            while (product >= k && left <= right) {
                product /= nums[left++];
            }

            result += right - left + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        SubarrayProductLessThanK s=new SubarrayProductLessThanK();
        int[] arr = {2, 5, 3, 10};
        int target = 30;
        int result = s.numSubarrayProductLessThanK(arr, target);
        System.out.println("Subarrays: " + result);
    }

}
