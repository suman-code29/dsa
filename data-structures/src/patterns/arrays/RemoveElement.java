package patterns.arrays;

import java.util.Arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int result = 0;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = 101;
            } else {
                result++;
            }
        }
        Arrays.sort(nums);
        return result;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        System.out.println(removeElement.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
}
