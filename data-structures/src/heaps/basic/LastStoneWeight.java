package heaps.basic;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i: stones) {
            priorityQueue.add(i);
        }

        if (priorityQueue.size() == 1) {
            return priorityQueue.peek();
        }

        while (priorityQueue.size() > 1) {
            int x = priorityQueue.poll();
            int y = priorityQueue.poll();

            if (y<=x) {
                if (x != y) {
                    priorityQueue.add(x-y);
                }
            }
        }
        return priorityQueue.peek() != null ? priorityQueue.peek():0;
    }

    public static void main(String[] args) {
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        System.out.println(lastStoneWeight.lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }

}
