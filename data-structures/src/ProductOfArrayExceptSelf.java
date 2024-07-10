import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] product = new int[n];
        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i=1; i<n;i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        int[] suffix = new int[n];
        suffix[n-1] = 1;
        for (int j=n-2; j>=0;j--) {
            suffix[j] = suffix[j+1] * nums[j+1];
        }

        for (int k =0; k<n; k++) {
            product[k] = prefix[k] * suffix[k];
        }

        return product;
    }

    public static void main(String[] args)
    {
        int[] arr = { 1 , 2, 3, 4};
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        Arrays.stream(productOfArrayExceptSelf.productExceptSelf(arr)).forEach(System.out::println);
    }
}
