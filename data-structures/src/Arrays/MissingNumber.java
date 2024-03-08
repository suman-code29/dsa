package Arrays;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(nums));
    }

    public int missingNumber(int[] nums) {
        Set<Integer> numberRange = new HashSet<>();
        for (int i = 0; i <= nums.length; i++) {
            numberRange.add(i);
        }
        for (int num : nums) {
            if (numberRange.contains(num)) {
                numberRange.remove(num);
            }
        }
        for (int num : numberRange) {
            return num;
        }
        return -1;
    }
}
