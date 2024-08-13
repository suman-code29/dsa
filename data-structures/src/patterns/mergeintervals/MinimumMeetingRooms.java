package patterns.mergeintervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumMeetingRooms {
    public int findMinMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(intervals[0][1]);

        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0] > minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.add(intervals[i][1]);
        }

        return minHeap.size();
    }

    public static void main(String[] args) {
        MinimumMeetingRooms minimumMeetingRooms = new MinimumMeetingRooms();
        System.out.println(minimumMeetingRooms.findMinMeetingRooms(new int[][]{{1,4},{2,5},{3,6}}));
//        System.out.println(minimumMeetingRooms.findMinMeetingRooms(new int[][]{{6,7},{2,4},{8,12}}));
//        System.out.println(minimumMeetingRooms.findMinMeetingRooms(new int[][]{{1,4},{2,3},{3,6}}));
//        System.out.println(minimumMeetingRooms.findMinMeetingRooms(new int[][]{{4,5},{2,3},{2,4},{3,5}}));
    }
}
