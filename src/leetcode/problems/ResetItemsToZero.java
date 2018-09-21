package leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;

/*
    Given an array and an operation -> foo(currentIndex, value), the value can be either 1 or -1, if foo(currentIndex, value) is called,
    it will add ‘value’ to all elements from currentIndex till end of the array,
    find minimum number of operation to make all array elements 0.
 */
public class ResetItemsToZero {

    public static void main(String[] args) {

        ResetItemsToZero resetItemsToZero = new ResetItemsToZero();

        // System.out.println(resetItemsToZero.findMimStepsToBecomeZero(new int[]{2, 0, 1}));
        System.out.println(resetItemsToZero.findMimStepsToBecomeZero(new int[]{2, -7, 3, 5}));
    }

    int findMimStepsToBecomeZero(int[] array) {
        ArrayNode original = new ArrayNode(array, 0);
        ArrayNode dest = new ArrayNode(new int[array.length]);

        HashSet<ArrayNode> visitedNodes = new HashSet<>();
        HashSet<ArrayNode> toVisitSet = new HashSet<>();
        toVisitSet.add(original);

        while (!toVisitSet.isEmpty()) {
            ArrayNode curr = findMinNodeFromSet(toVisitSet);

            for (int i = 0 ; curr != null && i < array.length; i ++) {
                ArrayNode up = curr.foo(i, true);
                ArrayNode down = curr.foo(i, false);

                addNode(visitedNodes, toVisitSet, curr, up);
                addNode(visitedNodes, toVisitSet, curr, down);
            }

            System.out.println(curr);

            if (dest.equals(curr)) {
                dest.minimum = curr.minimum;
                break;
            }

            visitedNodes.add(curr);
        }

        return dest.minimum;
    }

    private ArrayNode findMinNodeFromSet(HashSet<ArrayNode> toVisitSet) {
        int min = Integer.MAX_VALUE;
        ArrayNode ret = null;
        for (ArrayNode node : toVisitSet) {
            if (node.minimum < min) {
                min = node.minimum;
                ret = node;
            }
        }
        toVisitSet.remove(ret);
        return ret;
    }

    public void addNode(
            HashSet<ArrayNode> visitedNodes,
            HashSet<ArrayNode> toVisitSet,
            ArrayNode curr,
            ArrayNode newNode) {
        if (!visitedNodes.contains(newNode)) {
            if (curr.minimum + 1 < newNode.minimum) {
                newNode.minimum = curr.minimum + 1;
            }
            toVisitSet.add(newNode);
        }
    }

    static class ArrayNode {
        int[] array;
        int minimum;

        public ArrayNode(int[] array) {
            this(array, Integer.MAX_VALUE);
        }

        public ArrayNode(int[] array, int minimum) {
            this.array = Arrays.copyOf(array, array.length);
            this.minimum = minimum;
        }

        public ArrayNode foo(int index, boolean add) {
            if (array == null || array.length == 0 || index < 0 || index >= array.length) {
                throw new IllegalArgumentException("");
            }

            int[] newArray = Arrays.copyOf(array, array.length);

            for (int i = index ; i < newArray.length ; i ++) {
                newArray[i] += add ? 1 : (-1);
            }

            return new ArrayNode(newArray);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) { return true; }
            if (o == null || getClass() != o.getClass()) { return false; }
            ArrayNode arrayNode = (ArrayNode) o;
            return Arrays.equals(array, arrayNode.array);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(array);
        }

        @Override
        public String toString() {
            return minimum + ", " + Arrays.toString(array);
        }
    }
}
