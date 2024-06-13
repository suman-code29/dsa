package arrays.basic;

import java.util.HashSet;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int range = nums.length;
        int result = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i: nums) {
            hashSet.add(i);
        }

        for(int j=0; j<=range; j++) {
            if (!hashSet.contains(j)) {
                result = j;
            }
        }
        return result;
    }
}
