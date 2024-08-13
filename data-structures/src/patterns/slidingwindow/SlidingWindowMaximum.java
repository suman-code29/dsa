package patterns.slidingwindow;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int start = 0;
        int max = Integer.MIN_VALUE;
        int idx = 0;
        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            max = Math.max(max, nums[i]);

            while(i >= k) {
                result[idx] = max;
                start++;
            }
        }

        return result;
    }
}
