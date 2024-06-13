package arrays.medium;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int result = Integer.MIN_VALUE;
        int i=0;
        int j=height.length-1;

        while(i<j) {
            int range = j-i;
            int min = Math.min(height[i], height[j]);
            result = Math.max(min*range, result);

            if (height[j] < height[i]) {
                j--;
            } else if (height[j] > height[i]) {
                i++;
            } else {
                i++;
            }
        }
        return result;
    }
}
