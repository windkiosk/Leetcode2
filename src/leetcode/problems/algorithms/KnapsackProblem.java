package leetcode.problems.algorithms;

public class KnapsackProblem {

    public static void main(String[] args) {
        int[] w = new int[] {1, 2, 4, 2, 5};
        int[] v = new int[] {5, 3, 5, 3, 2};

        KnapsackProblem knapsackProblem = new KnapsackProblem();
        System.out.println(knapsackProblem.findBiggestRecursion(w, v, 10));
//        System.out.println(knapsackProblem.findBiggestValue(w, v, 10));
//        System.out.println(knapsackProblem.findBiggestValue_small_storage(w, v, 10));
        return;
    }

    int findBiggestRecursion(int[] weights, int[] values, int size) {
        int[][] p = new int[weights.length][size + 1];
        for (int i = 0 ; i < weights.length; i ++) {
            for (int j = 0; j <= size; j ++) {
                p[i][j] = -1;
            }
        }
        return findBiggestHelper(weights, values, size, 0, p);
    }

    int findBiggestHelper(int[] weights, int[] values, int size, int index, int[][] memo) {
        if (index == weights.length || size <= 0) return 0;
        if (memo[index][size] >= 0) {
            System.out.println("it works");
            return memo[index][size];
        }

        int w = weights[index];
        int v = values[index];

        int v1 = findBiggestHelper(weights, values, size, index + 1, memo);
        int v2 = 0;
        if (w <= size) {
            v2 = v + findBiggestHelper(weights, values, size - w, index + 1, memo);
        }

        int ret = Integer.max(v1, v2);
        memo[index][size] = ret;
        return ret;
    }

    int findBiggestValue(int[] weights, int[] values, int size) {
        if (size <= 0) { return 0; }
        if (weights == null
                || values == null
                || weights.length == 0
                || values.length == 0
                || weights.length != values.length) {
            throw new IllegalArgumentException("wrong weight/values array");
        }

        int[][] p = new int[weights.length + 1][size + 1];
        for (int i = 0; i < weights.length; i++) {
            int w = weights[i];
            int v = values[i];

            for (int j = 1; j <= size; j++) {
                if (j - w >= 0) {
                    if (p[i][j - w] + v > p[i][j]) {
                        p[i + 1][j] = p[i][j - w] + v;
                    } else {
                        p[i + 1][j] = p[i][j];
                    }
                } else {
                    p[i + 1][j] = p[i][j];
                }
            }
        }

        return p[weights.length][size];
    }

    int findBiggestValue_small_storage(int[] weights, int[] values, int size) {
        if (size <= 0) { return 0; }
        if (weights == null
                || values == null
                || weights.length == 0
                || values.length == 0
                || weights.length != values.length) {
            throw new IllegalArgumentException("wrong weight/values array");
        }

        int[] p = new int[size + 1];
        for (int i = 0; i < weights.length; i++) {
            int w = weights[i];
            int v = values[i];

            for (int j = size; j >= 1; j--) {
                if (j - w >= 0) {
                    if (p[j - w] + v > p[j]) {
                        p[j] = p[j - w] + v;
                    }
                }
            }
        }

        return p[size];
    }
}
