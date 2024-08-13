package patterns.arrays.medium;

import java.util.*;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
//        return countSubarrays(nums, 0, k, 0); // using recursion
        int prefixSum = 0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for(int i=0; i<nums.length; i++) {
            prefixSum = prefixSum + nums[i];
            int temp = prefixSum-k;
            if (map.containsKey(temp)) {
                result += map.get(temp);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        }

        return result;
    }

    private int countSubarrays(int[] nums, int start, int k, int currentSum) {
        if (start >= nums.length) {
            return 0;
        }

        int result = 0;
        int sum = currentSum;

        for (int i = start; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                result++;
            }
        }

        result += countSubarrays(nums, start + 1, k, currentSum);

        return result;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        System.out.println(subarraySumEqualsK.subarraySum(new int[]{1,1,1}, 2));
    }
}
