package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description of Question
 * Problem
 *
 * Given 2 sets of intervals.
 *
 * Interval is defined with left and right border and discrete points, like [2, 3], [0, 0], etc.
 *
 * Set of intervals is non intersected set of sorted intervals, for example: [0, 0], [2, 2], [5, 10] is a valid set of intervals, but [0, 0], [1, 2] is not valid, because you can write it as [0, 2]. [0, 2], [1, 5] is not valid as well, since these two intervals intersect.
 *
 * You need to find the AND or OR operation of these two sets. For example:
 *
 * 1st set: [0, 2], [5, 10], [16, 20]
 * 2nd set: [1, 5], [10, 18], [20, 23]
 *
 * AND Result: [1, 2], [5, 5], [10, 10], [16, 18], [20, 20]
 * OR Result: [0, 23]
 */
public class MergeTwoInterval {

    public static void main(String[] args) {
        MergeTwoInterval mergeTwoInterval = new MergeTwoInterval();

        int[][] left = new int[][]{{0, 2}, {5, 10}, {16, 20}};
        int[][] right = new int[][]{{1, 5}, {10, 18}, {20, 23}, {25, 27}};

        int[][] result = mergeTwoInterval.andOp(left, right);

        for (int[] val : result) {
            System.out.println(Arrays.toString(val));
        }
    }

    private int[][] andOp(int[][] left, int[][] right) {
        List<int[]> list = new ArrayList<>();

        int leftIndex = 0, rightIndex = 0;
        int leftEdge = Integer.MIN_VALUE, rightEdge = Integer.MIN_VALUE;
        while (leftIndex < left.length || rightIndex < right.length) {
            int leftVal, rightVal;
            if (rightIndex >= right.length || (leftIndex < left.length && left[leftIndex][0] <= right[rightIndex][0])) {
                // left queue head is smaller
                leftVal = left[leftIndex][0];
                rightVal = left[leftIndex][1];
                leftIndex++;
            } else {
                leftVal = right[rightIndex][0];
                rightVal = right[rightIndex][1];
                rightIndex++;
            }

            if (leftVal > rightEdge) {
                leftEdge = leftVal;
                rightEdge = rightVal;

                if (leftIndex >= left.length || rightIndex >= right.length) {
                    break;
                }
            } else {
                int overlapLeft = Math.max(leftEdge, leftVal);
                int overlapRight = Math.min(rightVal, rightEdge);
                list.add(new int[]{overlapLeft, overlapRight});

                leftEdge = overlapRight;
                rightEdge = Math.max(rightEdge, rightVal);
            }
        }

        int size = list.size();
        int[][] ret = new int[size][2];
        for (int i = 0 ; i < size; i ++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
