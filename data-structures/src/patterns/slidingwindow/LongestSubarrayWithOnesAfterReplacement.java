package patterns.slidingwindow;

public class LongestSubarrayWithOnesAfterReplacement {
    public int findLength(int[] nums, int k) {
        int maxOnesCount = 0;
        int result = 0;
        int start = 0;

        for(int i=0; i<nums.length; i++) {
            if (nums[i] == 1) {
                maxOnesCount++;
            }

            if (i-start+1-maxOnesCount > k) {
                if (nums[start] == 1) {
                    maxOnesCount--;
                    start++;
                } else {
                    start++;
                }
            }
            result = Math.max(result, i-start+1);
        }
        return result;
    }

    public static void main(String[] args) {
        LongestSubarrayWithOnesAfterReplacement l = new LongestSubarrayWithOnesAfterReplacement();
        System.out.println(l.findLength(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
    }
}
