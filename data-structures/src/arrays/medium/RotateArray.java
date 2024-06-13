package arrays.medium;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i=0; i<nums.length; i++) {

            result[(i + k) % nums.length] = nums[i];
        }
        for (int j=0;j<result.length;j++) {
            nums[j] = result[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(arr, k);
    }
}
