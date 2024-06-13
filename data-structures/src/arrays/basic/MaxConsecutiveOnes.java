package arrays.basic;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        boolean br;
        int result = 0;
        int count = 0;
        for(int i=0; i<nums.length;i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                br = true;
                result = Math.max(result, count);
                count = 0;
            }
        }
        result = Math.max(result, count);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,0,1,1,1};
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        System.out.println(maxConsecutiveOnes.findMaxConsecutiveOnes(arr));
    }
}
