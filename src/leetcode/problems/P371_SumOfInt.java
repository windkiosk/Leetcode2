package leetcode.problems;

/**
 * Check into this topic: https://discuss.leetcode.com/topic/50315/a-summary-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently
 */
public class P371_SumOfInt {

    public static void main(String[] strings) {
        P371_SumOfInt sumOfInt371 = new P371_SumOfInt();
        System.out.println(sumOfInt371.sum(2, 10));
        System.out.println(sumOfInt371.sum(9, -2));
        System.out.println(sumOfInt371.sum(2, -9));
    }

    int sum(int a, int b) {
        while (b != 0) {
            int bit = a ^ b;
            int lev = (a & b) << 1;
            a = bit;
            b = lev;
        }
        return a;
    }
}
