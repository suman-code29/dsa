package sorting;

public class SelectionSort {
    static void selectionSort(int arr[], int n) {
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            int minimum = Integer.MAX_VALUE;
            for(int j=0; j<n; j++) {
                if (arr[j] < minimum) {
                    minimum = arr[j];
                }
            }
            result[i] = minimum;
        }
        for (int value:result) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {7,5,9,2,8};
        selectionSort(arr, 5);
    }
}
