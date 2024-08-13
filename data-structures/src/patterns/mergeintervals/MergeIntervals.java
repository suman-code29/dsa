package patterns.mergeintervals;

import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntevals = new LinkedList<>();

        if (intervals.size() < 2) {
            return intervals;
        }

        intervals.sort(Comparator.comparingInt(a -> a.start));
        Iterator<Interval> intervalIterator = intervals.iterator();
        Interval interval = intervalIterator.next();
        int start = interval.start;
        int end = interval.end;

        while(intervalIterator.hasNext()) {
            interval = intervalIterator.next();
            if (interval.start <= end) {
                end = Math.max(interval.end, end);
            } else {
                mergedIntevals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        mergedIntevals.add(new Interval(start, end));
        return mergedIntevals;
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        int[] first = intervals[0];

        int start = first[0];
        int end = first[1];

        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0] < end) {
                end = Math.max(intervals[i][1], end);
            } else {
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        result.add(new int[]{start, end});
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(2, 5));
        intervals.add(new Interval(7, 9));

        for (Interval interval : MergeIntervals.merge(intervals)) {
            System.out.println(interval.start + ":" + interval.end);
        }
        System.out.println();
    }
}
