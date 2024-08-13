package patterns.twopointers;

import java.util.Arrays;

public class PairWithTargetSum {
    public static int[] search(int[] arr, int targetSum) {
        int left = 0;
        int right = arr.length-1;
        int[] result = new int[2];

        while(left <= right) {
            if (arr[left] + arr[right] == targetSum) {
                result[0] = left;
                result[1] = right;
                break;
            } else if (arr[left] + arr[right] > targetSum) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Arrays.stream(search(new int[]{3,2,4}, 6)).forEach(System.out::println);
    }
}
