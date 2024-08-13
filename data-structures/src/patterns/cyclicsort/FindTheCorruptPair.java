package patterns.cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class FindTheCorruptPair {
    public List<Integer> findPair(int[] nums) {
        int i = 0;
        List<Integer> result = new ArrayList<>();
        while(i < nums.length) {
            int correctIdx = nums[i]-1;
            if (nums[i] != nums[correctIdx]) {
                int temp = nums[correctIdx];
                nums[correctIdx] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        for(int k=0; k<nums.length; k++) {
            if (nums[k] != k+1) {
                result.add(nums[k]);
                result.add(k+1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindTheCorruptPair findTheCorruptPair = new FindTheCorruptPair();
        System.out.println(findTheCorruptPair.findPair(new int[]{3, 1, 2, 5, 2}));
    }
}
