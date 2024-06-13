package binarysearch.medium;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    static int lowerBound(int[] arr, int n, int target) {
        int low = 0;
        int high = n-1;
        int ans = n;

        while (high >= low) {
            int mid = (high+low)/2;
            if (arr[mid] >= target) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }

    static int upperBound(int[] arr, int n, int target) {
        int low = 0;
        int high = n-1;
        int ans = n;

        while (high >= low) {
            int mid = (high+low)/2;
            if (arr[mid] > target) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int lb = lowerBound(nums, nums.length, target);
        if (lb == nums.length || nums[lb] != target) return new int[]{-1,-1};
        return new int[]{lb, upperBound(nums, nums.length, target)-1};
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray findFirstAndLastPositionOfElementInSortedArray = new FindFirstAndLastPositionOfElementInSortedArray();
        System.out.println(Arrays.toString(findFirstAndLastPositionOfElementInSortedArray.searchRange(new int[]{5,7,7,8,8,10}, 8)));
    }
}
