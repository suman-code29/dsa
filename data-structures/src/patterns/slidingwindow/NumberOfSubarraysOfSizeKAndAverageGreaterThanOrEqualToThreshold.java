package patterns.slidingwindow;

public class NumberOfSubarraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int result = 0;
        while (end < arr.length) {
            sum += arr[end];
            if (end-start+1 > k-1) {
                if (sum/k >= threshold) {
                    result++;
                }
                sum-=arr[start];
                start++;
            }
            end++;
        }

        return result;
    }
}
