package binarysearch.basic;

public class FloorInASortedArray {
    static int findFloor(long arr[], int n, long x) {
        int ans = Integer.MIN_VALUE;
        int low = 0;
        int high = n-1;

        while(low<=high) {
            int mid = low + (high-low)/2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                high = mid-1;
            } else if (arr[mid] < x) {
                ans = mid;
                low = mid+1;
            }
        }
        return ans == 0 ? -1 : ans;
    }

    public static void main(String[] args) {
        long[] arr = new long[]{1,6,8,9};
        System.out.println(findFloor(arr, 4, 4));
    }
}
