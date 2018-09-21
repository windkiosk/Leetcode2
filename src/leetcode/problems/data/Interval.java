package leetcode.problems.data;

public class Interval {

    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    public static Interval[] generate(int[][] input) {
        int size = input.length;
        Interval[] intervals = new Interval[size];
        for (int i = 0; i < size; i++) {
            intervals[i] = new Interval(input[i][0], input[i][1]);
        }
        return intervals;
    }
}
