package leetcode.problems;

public class P279_PerfectSquare {

    public static void main(String[] strings) {
        P279_PerfectSquare perfectSquare_279 = new P279_PerfectSquare();
        System.out.println(perfectSquare_279.numSquares_dynamic_programming(12));
    }

    public int numSquares_dynamic_programming(int n) {
        if (n <= 1) return n;

        int[] ret = new int[n + 1];
        ret[0] = 0;
        ret[1] = 1;

        for (int i = 2; i <= n; i ++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j ++) {
                min = Math.min(min, ret[i - j * j] + 1);
            }
            ret[i] = min;
        }

        return ret[n];
    }
}
