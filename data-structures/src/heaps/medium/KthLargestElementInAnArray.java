package heaps.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i : nums) {
            heap.add(i);
        }
        int temp = 0;
        for (int j=0; j<k; j++) {
            if (heap.peek() != null) {
                temp = heap.poll();
            }
        }
        return temp;
    }
}
