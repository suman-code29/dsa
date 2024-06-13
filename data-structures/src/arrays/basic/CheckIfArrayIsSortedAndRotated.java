package arrays.basic;

import arrays.medium.RotateArray;

public class CheckIfArrayIsSortedAndRotated {
    public boolean check(int[] nums) {
        int count = 0;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                count++;
            }
        }

        if (nums[nums.length-1] > nums[0]) {
            count++;
        }

        return count <= 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,2,3,4,5,6,7};
        CheckIfArrayIsSortedAndRotated checkIfArrayIsSortedAndRotated = new CheckIfArrayIsSortedAndRotated();
        System.out.println(checkIfArrayIsSortedAndRotated.check(arr));
    }
}
