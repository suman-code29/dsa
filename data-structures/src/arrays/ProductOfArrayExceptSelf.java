package arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        int[] result = productOfArrayExceptSelf.productExceptSelf(nums);
        System.out.println(result);
    }

    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefix[i] = nums[i];
            } else {
                prefix[i] = nums[i] * prefix[i - 1];
            }
        }
        int[] postfix = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                postfix[i] = nums[i];
            } else {
                postfix[i] = nums[i] * postfix[i + 1];
            }
        }
        int[] result = new int[nums.length];
        for (int j = 0; j < nums.length; j++) {
            if (j == 0) {
                result[j] = postfix[j + 1];
            } else if (j == nums.length - 1) {
                result[j] = prefix[j - 1];
            } else {
                result[j] = prefix[j - 1] * postfix[j + 1];
            }
        }
        return result;
    }
}
