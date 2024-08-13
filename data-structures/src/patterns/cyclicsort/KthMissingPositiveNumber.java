package patterns.cyclicsort;

import java.util.*;

public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int current = 1;
        int index = 0;
        int count = 0;

        while (true) {
            if (index < arr.length && current == arr[index]) {
                index++;
            } else {
                count++;
                if (count == k) {
                    return current;
                }
            }
            current++;
        }
    }

    public static void main(String[] args) {
        KthMissingPositiveNumber k = new KthMissingPositiveNumber();
        System.out.println(k.findKthPositive(new int[]{2,3,4,7,11}, 5));
    }
}
