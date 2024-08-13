package patterns.slidingwindow;

public class MaxSumSubArrayOfSizeK {
    public int findMaxSumSubArray(int[] arr, int k) {
        int start = 0;
        int sum = 0;
        int max = 0;

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            if (i >= k-1) {
                max = Math.max(max, sum);
                sum -= arr[start];
                start++;
            }
        }

        return Math.max(sum, max);
    }

    public static void main(String[] args) {
        MaxSumSubArrayOfSizeK maxSumSubArrayOfSizeK = new MaxSumSubArrayOfSizeK();
        System.out.println(maxSumSubArrayOfSizeK.findMaxSumSubArray(new int[]{400,200,300,100}, 2));
    }
}
