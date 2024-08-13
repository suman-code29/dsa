package patterns.twopointers;

public class MinimumWindowSort {
    public int findUnsortedSubarray(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while(low<nums.length-1 && nums[low] <= nums[low+1]) {
            low++;
        }

        if (low == nums.length-1) {
            return 0;
        }
        while(high > low && nums[high] >= nums[high-1]) {
            high--;
        }

        int subArrayMax = Integer.MIN_VALUE;
        int subArrayMin = Integer.MAX_VALUE;

        for(int k=low; k<=high; k++) {
            subArrayMin = Math.min(subArrayMin, nums[k]);
            subArrayMax = Math.max(subArrayMax, nums[k]);
        }

        while(low>0 && nums[low-1] > subArrayMin) low--;
        while(high<nums.length-1 && nums[high+1] < subArrayMax) high++;

        return high-low+1;
    }

    public static void main(String[] args) {
        MinimumWindowSort minimumWindowSort = new MinimumWindowSort();
        System.out.println(minimumWindowSort.findUnsortedSubarray(new int[]{1,3,2,2,2}));
    }
}
