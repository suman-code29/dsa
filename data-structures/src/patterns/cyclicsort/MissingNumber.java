package patterns.cyclicsort;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int i = 0;
        while(i<nums.length) {
            int correctIdx = nums[i];
            if (nums[i] < nums.length && nums[i] != nums[correctIdx]) {
                int temp = nums[correctIdx];
                nums[correctIdx] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }
        for (int k=0; k<nums.length; k++){
            if (nums[k] != k) {
                return k;
            }
        }
        return nums[nums.length-1]+1;
    }

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(new int[]{3,0,1}));
    }
}
