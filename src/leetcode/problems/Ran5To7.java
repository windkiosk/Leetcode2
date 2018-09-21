package leetcode.problems;

import java.util.Random;

public class Ran5To7 {
    private static int[][] VAL = new int[][] {
            {1, 2, 3, 4, 5},
            {6, 7, 1, 2, 3},
            {4, 5, 6, 7, 1},
            {2, 3, 4, 5, 6},
            {7, 0, 0, 0, 0}
    };

    private Random random = new Random();

    public static void main(String[] args) {
        Ran5To7 ran5To7 = new Ran5To7();
        for (int i = 0; i < 100; i ++) {
            System.out.println(ran5To7.rand7());
        }
    }

    private int rand7() {
        int ret = 0;
        while (ret == 0) {
            int i = rand5();
            int j = rand5();
            ret = VAL[i - 1][j - 1];
        }
        return ret;
    }

    private int rand5() {
        return random.nextInt(5) + 1;
    }
}
