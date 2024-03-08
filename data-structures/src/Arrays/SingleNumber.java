package Arrays;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public static void main(String[] args) {
        int[] ans = new int[]{2, 2, 1};
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(ans));
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(nums[i])) {
                numMap.put(nums[i], numMap.get(nums[i]) + 1);
            } else {
                numMap.put(nums[i], 1);
            }
        }

        for (int num : nums) {
            if (numMap.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }
}
