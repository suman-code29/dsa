package binarysearch.basic;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while(high >= low) {
            int mid = (high + low)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid-1;
            } else if (nums[mid] < target) {
                low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,3,5,9,12};
        int target = 3;
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(arr, target));
    }
}
