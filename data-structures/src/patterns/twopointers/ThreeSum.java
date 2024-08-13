package patterns.twopointers;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++) {
            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            searchTriplet(nums, -nums[i], i+1, result);
        }

        return result;
    }

    public void searchTriplet(int[] arr, int target, int left, List<List<Integer>> result) {
        int right = arr.length-1;

        while(left < right) {
            if (arr[left] + arr[right] == target) {
                result.add(Arrays.asList(-target, arr[left], arr[right]));
                left++;
                right--;

                while(left<right && arr[left] == arr[left-1]) {
                    left++;
                }
                while(left<right && arr[right] == arr[right+1]) {
                    right--;
                }
            } else if (target > arr[left] + arr[right]) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
