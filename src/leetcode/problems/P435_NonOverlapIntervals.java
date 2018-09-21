package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

import leetcode.problems.data.Interval;

public class P435_NonOverlapIntervals {

    public static void main(String[] strings) {
        Interval[] intervals = Interval.generate(new int[][] {{1, 2}, {2, 3}, {3, 4}, {1, 3}});
        P435_NonOverlapIntervals nonOverlapIntervals435 = new P435_NonOverlapIntervals();
        System.out.println(nonOverlapIntervals435.eraseOverlapIntervals(intervals));
    }

    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length < 2) { return 0; }

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.end < o2.end) {
                    return -1;
                } else if (o1.end > o2.end) {
                    return 1;
                } else {
                    if (o1.start < o2.start) {
                        return -1;
                    } else if (o1.start > o2.start) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        });

        int toRemove = 0;
        Interval last = null;
        for (Interval interval : intervals) {
            if (last == null) {
                last = interval;
            } else {
                if (interval.start < last.end) {
                    toRemove ++;
                } else {
                    last = interval;
                }
            }
        }

        return toRemove;
    }
}
