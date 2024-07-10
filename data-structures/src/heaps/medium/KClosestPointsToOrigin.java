package heaps.medium;


import java.util.Objects;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    static class Pair implements Comparable<Pair> {
        private final int first;
        private final int second;
        private final int key;

        public Pair(int first, int second, int key) {
            this.first = first;
            this.second = second;
            this.key = key;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }

        public int getKey() {return key; }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.key, other.key);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> heap = new PriorityQueue<>();
        for (int[] i : points) {
            int distance = (int) Math.sqrt(i[0] * i[0] + i[1] * i[1]);
            if (heap.size() < k) {
                heap.add(new Pair(i[0], i[1], distance));
            } else if (heap.peek().getKey() < distance) {
                heap.poll();
                heap.add(new Pair(i[0], i[1], distance));
            }
        }

        int[][] result = new int[k][2];

        for (int j=0; j<k; j++) {
            result[j][0] = Objects.requireNonNull(heap.poll()).getFirst();
            result[j][1] = Objects.requireNonNull(heap.poll()).getSecond();
        }

        return result;
    }


}
