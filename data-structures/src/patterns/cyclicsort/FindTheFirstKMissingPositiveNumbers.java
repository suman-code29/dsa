package patterns.cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class FindTheFirstKMissingPositiveNumbers {
    public List<Integer> findFirstKMissingPositive(int[] nums, int k) {
        int i=0;
        while(i<nums.length) {
            int correctIdx = nums[i]-1;
            if (nums[i] <= nums.length && nums[i] > 0 && nums[i] != nums[correctIdx]) {
                int temp = nums[correctIdx];
                nums[correctIdx] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }
        List<Integer> result = new ArrayList<>();

        for(int j=0; j<nums.length; j++) {
            if (nums[j] != j+1 && k>0) {
                result.add(k+1);
                k--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindTheFirstKMissingPositiveNumbers f = new FindTheFirstKMissingPositiveNumbers();
        System.out.println(f.findFirstKMissingPositive(new int[]{3, -1, 4, 5, 5}, 3));
    }
}
