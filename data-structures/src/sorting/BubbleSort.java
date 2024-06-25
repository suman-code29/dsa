package sorting;

import java.util.Arrays;
import java.util.stream.Stream;

public class BubbleSort {
    public int[] bubbleSort(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            for (int j=0; j<arr.length-i-1 ; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.bubbleSort(new int[]{2, 5, 4, 3, 9, 7, 1});
        Arrays.stream(result).forEach(value -> System.out.println(value));
//        Stream.of(result).forEach(value -> System.out.println(value));
    }
}
