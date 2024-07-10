package heaps.basic;

import java.util.*;

public class KthLargest {
    PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i : nums) add(i);
    }

    public int add(int val) {
        if (integerPriorityQueue.size() < k) {
            integerPriorityQueue.offer(val);
        } else if (val > integerPriorityQueue.peek()){
            integerPriorityQueue.poll();
            integerPriorityQueue.offer(val);
        }
        return integerPriorityQueue.peek();
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
