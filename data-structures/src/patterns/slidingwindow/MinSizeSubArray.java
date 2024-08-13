package patterns.slidingwindow;

public class MinSizeSubArray {
    public int findMinSizeSubArray(int[] arr, int sum) {
        int minWindow = Integer.MAX_VALUE;
        int windowSum = 0;
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd<arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            while(windowSum >= sum) {
                minWindow = Math.min(minWindow, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return minWindow == Integer.MIN_VALUE ? 0 : minWindow;
    }

    public static void main(String[] args) {
        MinSizeSubArray minSizeSubArray = new MinSizeSubArray();
        System.out.println(minSizeSubArray.findMinSizeSubArray(new int[]{2,1,5,2,3,2}, 7));
    }
}
