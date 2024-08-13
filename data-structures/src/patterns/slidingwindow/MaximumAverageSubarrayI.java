package patterns.slidingwindow;

public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int start = 0;
        int end = 0;
        double sum = 0;
        double result = 0;
        while (end < nums.length) {
            sum += nums[end];
            if (end-start+1 > k-1) {
                result = Math.max(result, sum/k);
                sum-=nums[start];
                start++;
            }
            end++;
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumAverageSubarrayI maximumAverageSubarrayI = new MaximumAverageSubarrayI();
        System.out.println(maximumAverageSubarrayI.findMaxAverage(new int[]{-1}, 1));
    }
}
