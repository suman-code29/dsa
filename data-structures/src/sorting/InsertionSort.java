package sorting;

public class InsertionSort {

    int print2largest(int arr[], int n) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            if ((arr[i] > first)) {
                second = first;
                first = arr[i];
            } else if ((arr[i] < first) && (arr[i] > second)) {
                second = arr[i];
            }
        }
        return second;
    }

    public static void main(String[] args) {
        int n = 42;
        int[] arr = new int[] {28,43,26,65,60,54,51,35,42,48,33,40,58,38,64,47,44,49,46,25,57,39,55,45,29,32,61,53,31,36,56,63,30,52,27,34,50,41,37,66,62,59};
        InsertionSort insertionSort = new InsertionSort();
        System.out.println(insertionSort.print2largest(arr,n));
    }
}
