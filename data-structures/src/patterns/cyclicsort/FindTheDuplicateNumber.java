package patterns.cyclicsort;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
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
                return nums[k];
            }
        }

        return -1;
    }
}
