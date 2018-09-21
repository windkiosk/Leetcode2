package leetcode.problems;

/**
 * Give an array of wood [5, 7, 9], if try to cut these wood into k pieces,
 * what's the longest woods we can get?
 *
 * For instance, if k = 3, in above array, the returned value should be 5.
 * if k = 4, the return value should be 4, because we can cut 5 into 4, and 9 into 2 of 4, and 7 into 4.
 */
public class CutWood {

    public static void main(String[] args) {
        int[] wood = new int[] {5, 7, 9};
        CutWood cutWood = new CutWood();
        System.out.println(cutWood.cutWood(wood, 4));
    }

    private int cutWood(int[] wood, int k) {
        return cutWood(wood, 0, k);
    }

    private int cutWood(int[] wood, int start, int k) {
        if (k == 0) return Integer.MAX_VALUE;
        if (start == wood.length) return 0;

        int max = 0;
        for (int i = 0; i <= k & i <= wood[start]; i ++) {
            int v = i == 0 ? Integer.MAX_VALUE : wood[start] / i;
            int next = cutWood(wood, start + 1, k - i);
            int m = Math.min(v, next);
            if (m > max) max = m;
        }
        return max;
    }
}
