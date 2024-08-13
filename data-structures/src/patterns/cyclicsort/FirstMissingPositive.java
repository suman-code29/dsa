package patterns.cyclicsort;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
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

        for(int k=0; k<nums.length; k++) {
            if (nums[k] != k+1) {
                return k+1;
            }
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{1,2,0}));
    }
}
