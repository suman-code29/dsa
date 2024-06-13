package binarysearch.medium;

import arrays.basic.SingleNumber;

public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int ans = 0;
        for (int i=0; i<nums.length;i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        SingleElementInASortedArray singleElementInASortedArray = new SingleElementInASortedArray();
        System.out.println(singleElementInASortedArray.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
    }
}
