package patterns.slidingwindow;

import java.util.Arrays;

public class KRadiusSubarrayAverages {
    public int[] getAverages(int[] nums, int k) {
        int idx = k;
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        int start = 0;
        long currentSum = 0;
        int window = k*2 + 1;

        for (int end = 0; end<nums.length; end++) {
            currentSum += nums[end];
            if (end-start+1 >= window) {
                result[idx] = (int) (currentSum/window);
                idx++;
                currentSum -= nums[start++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        KRadiusSubarrayAverages k = new KRadiusSubarrayAverages();
        Arrays.stream(k.getAverages(new int[]{7,4,3,9,1,8,5,2,6}, 3)).forEach(System.out::println);
    }
}
