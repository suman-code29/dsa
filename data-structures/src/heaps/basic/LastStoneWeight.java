package heaps.basic;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : stones) {
            heap.offer(i);
        }
        if (heap.size() == 1) {
            return heap.peek();
        }
        while (heap.size() > 1) {
            int y = heap.poll();
            int x = heap.poll();

            if (x <= y) {
                if (x == y) {
                    continue;
                } else {
                    heap.add(y-x);
                }
            }
        }
        return !heap.isEmpty() ? heap.peek() : 0;
    }

    public static void main(String[] args) {
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        System.out.println(lastStoneWeight.lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }

}
