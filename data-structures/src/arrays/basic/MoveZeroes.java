package arrays.basic;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int i=0;
        int j=i+1;
        while ((nums[i] != 0) && (j <= nums.length-1)) {
            i++;
            j++;
        }
        while(j <= nums.length-1) {
            if ((nums[i] == 0) && (nums[j] != 0)) {
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
                j++;
            } else {
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
    }
}
