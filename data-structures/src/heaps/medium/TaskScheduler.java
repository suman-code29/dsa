package heaps.medium;

import java.util.*;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for (char i : tasks) {
            arr[i - 'A']++;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0; i<26; i++) {
            if (arr[i] > 0) {
                heap.add(arr[i]);
            }
        }

        int time = 0;
        int freq;

        while(!heap.isEmpty()) {
            Queue<Integer> q = new LinkedList<>();
            for (int i=0; i<=n; i++) {
                if (heap.peek() != null) {
                    freq = heap.peek();
                    heap.poll();
                    freq--;
                    q.add(freq);
                }
            }

            for (int i:q) {
                if (i > 0) {
                    heap.add(i);
                }
            }
            if (heap.isEmpty()) {
                time = time + q.size();
            } else {
                time = time+n+1;
            }
        }

        return time;
    }

    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
        char[] chars = new char[]{'A','A','A','B','B','B'};
        System.out.println(taskScheduler.leastInterval(chars, 2));

        char[] chars2 = new char[]{'A','C','A','B','D','B'};
        System.out.println(taskScheduler.leastInterval(chars2, 1));
    }
}
