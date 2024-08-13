package patterns.cyclicsort;

import java.util.Arrays;

public class CyclicSort {
    public int[] cyclicsort(int[] nums) {
        int i = 0;
        while(i<nums.length) {
            if (nums[i] != i+1) {
                int j = nums[i];
                int temp = nums[j-1];
                nums[j-1] = j;
                nums[i] = temp;
            } else {
                i++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        CyclicSort cyclicSort = new CyclicSort();
        Arrays.stream(cyclicSort.cyclicsort(new int[]{3,1,2,4})).forEach(System.out::println);
    }
}
