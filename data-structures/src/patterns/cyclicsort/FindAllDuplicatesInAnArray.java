package patterns.cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int i=0;
        while(i<nums.length) {
            int correctIdx = nums[i]-1;
            if (nums[i] != nums[correctIdx]) {
                int temp = nums[correctIdx];
                nums[correctIdx] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        for(int k = 0; k<nums.length; k++) {
            if (nums[k] != k+1) {
                result.add(nums[k]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindAllDuplicatesInAnArray f = new FindAllDuplicatesInAnArray();
        System.out.println(f.findDuplicates(new int[]{1,1,2}));
    }
}
