package arrays.medium;

public class SortColors {
    // Use Dutch National Flag algorithm
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n-1;
        int temp = 0;

        while (mid <= high) {
            if (nums[mid] == 0) {
                temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                mid++;
                low++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0};
        SortColors sortColors = new SortColors();
        sortColors.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
