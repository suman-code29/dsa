package arrays.basic;

import java.util.HashMap;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                int present = map.get(nums[i]);
                map.put(nums[i], present+1);
            }
        }

        for (int j=0; j<nums.length; j++) {
            if (map.get(nums[j]) == 1) {
                result = nums[j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,1};
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(arr));
    }
}
