package patterns.twopointers;

public class SortedArraysSquare {
    public static int[] makeSquares(int[] nums) {
        int n = nums.length;
        int[] squares = new int[nums.length];
        int left = 0;
        int right = n-1;
        int highestIndex = n-1;

        while(left < right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                squares[highestIndex--] = leftSquare;
                left++;
            } else {
                squares[highestIndex--] = rightSquare;
                right--;
            }
        }

        return squares;
    }
}
