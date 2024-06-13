package heaps.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KthLargest {
    int kLargestElement;
    List<Integer> arr = new ArrayList<>();
    int k;

    public KthLargest(int k, int[] nums) {

        for (int i : nums) {
            arr.add(i);
        }
        arr.sort(Collections.reverseOrder());
        this.k = k;
        this.kLargestElement = arr.get(k-1);
    }

    public int add(int val) {
        arr.add(val);
        arr.sort(Collections.reverseOrder());
        kLargestElement = arr.get(k-1);
        return kLargestElement;
    }


    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4,5,8,2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}
