package patterns.mergeintervals;

import java.util.Arrays;
import java.util.Comparator;

public class ConflictingAppointments {
    public boolean canAttendAllMeetings(int[][] intervals) {
        if (intervals.length == 0) {
            return true;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for(int i=0; i<intervals.length-1; i++) {
            if (intervals[i][1] >= intervals[i+1][0]) {
                return false;
            }
        }

        return true;
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int lastEnd = intervals[0][1];
        for(int i=1; i<intervals.length; i++) {
            if (intervals[i][0] < lastEnd) {
                result++;
                lastEnd = Math.min(lastEnd, intervals[i][1]);
            } else {
                lastEnd = intervals[i][1];
            }
        }

        return result;
    }


    public static void main(String[] args) {
        ConflictingAppointments conflictingAppointments = new ConflictingAppointments();
        conflictingAppointments.eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2}});
    }
}
