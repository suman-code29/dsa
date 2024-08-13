package patterns.twopointers;

public class RemoveDuplicates {
    public static int remove(int[] arr) {
        int j=1;
        for(int i=1; i<arr.length; i++) {
            if (arr[j-1] != arr[i]) {
                arr[j] = arr[i];
                j++;
            }
        }

        return j;
    }

    public static void main(String[] args) {
        System.out.println(remove(new int[]{2, 2, 2, 11}));
    }
}
