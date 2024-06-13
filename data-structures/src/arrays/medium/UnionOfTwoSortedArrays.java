package arrays.medium;

import java.util.*;
import java.util.stream.Collectors;

public class UnionOfTwoSortedArrays {
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n ; i++) {
            set.add(arr1[i]);
        }

        for(int i=0; i<m ; i++) {
            set.add(arr2[i]);
        }

        ArrayList<Integer> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{1, 2, 3, 6, 7};
        findUnion(arr1, arr2, arr1.length, arr2.length);
    }
}
