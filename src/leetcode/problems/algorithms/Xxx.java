package leetcode.problems.algorithms;

//X[n] = X[n-1] + X[n-2]
public class Xxx {

    public static void main(String[] strings) {
        Xxx xxx = new Xxx();
        System.out.println(xxx.recursive(5));
        System.out.println(xxx.dp(5));
    }

    int dp(int n) {
        if (n < 2) {
            return n;
        }

        int[] ret = new int[n + 1];
        ret[0] = 0;
        ret[1] = 1;

        for (int i = 2; i <= n; i ++) {
            ret[i] = ret[i - 1] + ret[i - 2];
        }

        return ret[n];
    }

    int recursive(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return recursive(n - 1) + recursive(n - 2);
        }
    }
}
