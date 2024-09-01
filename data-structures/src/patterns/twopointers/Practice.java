package patterns.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {
    public List<List<Integer>> tripletSumToZero(int[] arr) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        for (int i=0; i<arr.length-2; i++) {
            if (i>0 && arr[i] == arr[i-1]) {
                continue;
            }
            tripletSumToZeroHelper(arr,i, -arr[i], result);
        }

        return result;
    }

    private void tripletSumToZeroHelper(int[] arr, int idx, int target, List<List<Integer>> result) {
        int left = idx+1;
        int right = arr.length-1;

        while(left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == target) {
                List<Integer> current = Arrays.asList(arr[left], arr[right], -target);
                result.add(current);
                left++;
                right--;
                while(left<right && arr[left] == arr[left-1]) {
                    left++;
                }
                while(left<right && arr[right] == arr[right+1]) {
                    right--;
                }
            } else if (currentSum > target) {
                right--;
            } else {
                left++;
            }
        }
    }

    public List<List<Integer>> quadrpletSumToTarget(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; i++){
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j=i+1; j<nums.length-2; j++) {
                if (j>i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                QuadrpletSumToTargetHelper(nums,i,j, target, result);
            }
        }
        return result;
    }

    private void QuadrpletSumToTargetHelper(int[] arr, int first, int second, int target, List<List<Integer>> result) {
        int left = second+1;
        int right = arr.length-1;

        while(left < right) {
            int currentSum = arr[left] + arr[right] + arr[first] + arr[second];
            if (currentSum == target) {
                List<Integer> current = Arrays.asList(arr[left], arr[right], arr[first], arr[second]);
                result.add(current);
                left++;
                right--;
                while(left<right && arr[left] == arr[left-1]) {
                    left++;
                }
                while(left<right && arr[right] == arr[right+1]) {
                    right--;
                }
            } else if (currentSum > target) {
                right--;
            } else {
                left++;
            }
        }
    }

    public int testCode() {
        int[] arr = {1,2,3,4,5,6,7,8,9,15};
        List<List<Integer>> result = quadrpletSumToTarget(arr, 30);
        System.out.println(result);
        return 0;
    }


    public static void main(String[] args) {
        Practice practice = new Practice();
        System.out.println(practice.tripletSumToZero(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        System.out.println(practice.quadrpletSumToTarget(new int[]{4, 1, 2, -1, 1, -3}, 1));
    }
}
