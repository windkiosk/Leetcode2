package leetcode.problems;

public class P70_ClimbingStairs {
    int counter = 0;

    public static void main(String[] args) {
        P70_ClimbingStairs p70_climbingStairs = new P70_ClimbingStairs();
        System.out.println(p70_climbingStairs.climbStairsRecursion(8));
        System.out.println(p70_climbingStairs.climbStairs(8));
    }

    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        int[] ret = new int[n + 1];
        ret[0] = 1;
        ret[1] = 1;

        for (int i = 2; i <= n; i ++) {
            ret[i] = ret[i - 1] + ret[i - 2];
        }

        return ret[n];
    }

    public int climbStairsRecursion(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int[] memo = new int[n + 1];
        return helper(n, 0, memo);
    }

    private int helper(int n, int i, int[] memo) {
        if (i >= n - 1) return 1;
        if(memo[i] > 0) return memo[i];
        System.out.println("counter: " + (counter ++));
        int ret = helper(n, i + 1, memo) + helper(n, i + 2, memo);
        memo[i] = ret;
        return ret;
    }
}
