package patterns.cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
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
                result.add(k+1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindAllNumbersDisappearedInAnArray f = new FindAllNumbersDisappearedInAnArray();
        System.out.println(f.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}
