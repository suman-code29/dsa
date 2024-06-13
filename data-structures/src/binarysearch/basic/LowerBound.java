package binarysearch.basic;

public class LowerBound {
    static int lowerBound(int[] arr, int n, int target) {
        int low = 0;
        int high = n-1;
        int ans = n;

        while (high >= low) {
            int mid = (high+low)/2;
            if (arr[mid] >= target) {
                ans = arr[mid];
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lowerBound(new int[]{2,4,5,6,7}, 5, 5));
    }
}
