package leetcode.problems;

/**
 * This problem was asked by Airbnb.
 *
 * Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.
 *
 * For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
 *
 * Follow-up: Can you do this in O(N) time and constant space?
 *
 */
public class SumOfNonAdj {
    int counter = 0;

    public static void main(String[] args) {
        SumOfNonAdj sumOfNonAdj = new SumOfNonAdj();
        System.out.println("-----");
        System.out.println(sumOfNonAdj.findMaxNonAdjacentRecur(new int[]{5, 1, 1, 5}));
        System.out.println("-----");
        System.out.println(sumOfNonAdj.findMaxNonAdjacentRecur(new int[]{2, 4, 6, 2, 5}));
    }

    int findMaxNonAdjacent(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int v0 = 0;
        int v1 = 0;

        for (int i = 0 ; i < nums.length ; i ++) {
            int v = nums[i];
            int newV1 = v + v0;
            v0 = Math.max(v0, v1);
            v1 = newV1;
        }

        return Math.max(v0, v1);
    }

    int findMaxNonAdjacentRecur(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] memo = new int[nums.length];
        return helper(nums, 0, memo);
    }

    private int helper(int[] nums, int i, int[] memo) {
        if (i >= nums.length) return 0;
        if (memo[i] > 0) return memo[i];

        System.out.println(++counter);

        int v0 = nums[i] + helper(nums, i + 2, memo);
        int v1 = helper(nums, i + 1, memo);

        int ret = Math.max(v0, v1);
        memo[i] = ret;

        return ret;
    }
}
