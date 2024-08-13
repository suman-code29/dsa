package patterns.arrays.medium;

import java.util.Arrays;

public class SortAnArray {

    private void conquer(int[] arr, int start, int mid, int end) {
        int[] merged = new int[end-start+1];
        int idx1 = start;
        int idx2 = mid+1;
        int x = 0;

        while(idx1 <= mid && idx2 <= end) {
            if(arr[idx1] <= arr[idx2]) {
                merged[x] = arr[idx1];
                x++;
                idx1++;
            } else {
                merged[x] = arr[idx2];
                x++;
                idx2++;
            }
        }

        while(idx1 <= mid) {
            merged[x] = arr[idx1];
            x++;
            idx1++;
        }

        while(idx2 <= end) {
            merged[x] = arr[idx2];
            x++;
            idx2++;
        }


        for(int i=0, j=start; i< merged.length; i++,j++) {
            arr[j] = merged[i];
        }
    }

    private void divide(int[] arr, int start, int end) {
        if(start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        divide(arr, start, mid);
        divide(arr, mid+1, end);
        conquer(arr, start, mid, end);

    }

    public int[] sortArray(int[] nums) {
        divide(nums, 0, nums.length-1);
        return nums;
    }

    public static void main(String[] args) {
        SortAnArray sortAnArray = new SortAnArray();
        Arrays.stream(sortAnArray.sortArray(new int[]{5,2,3,1})).forEach(System.out::println);
    }
}
