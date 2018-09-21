package leetcode.problems;

import java.util.Stack;

import javafx.util.Pair;

public class P42_TrappingRainWater {

    public int trap(int[] height) {
        int trippedWater = 0;
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        for (int i = 0; i < height.length; i ++) {
            int h = height[i];
            if (stack.empty()) {
                stack.push(new Pair<>(h, i));
            } else if(h > stack.peek().getKey()) {
                while (!stack.empty() && h > stack.peek().getKey()) {
                    Pair<Integer, Integer> top = stack.pop();
                    if (!stack.empty()) {
                        trippedWater += (i - stack.peek().getValue() - 1)
                                * (Math.min(stack.peek().getKey(), h) - top.getKey());
                    }
                }
                stack.push(new Pair<>(h, i));
            } else if (h < stack.peek().getKey()) {
                stack.push(new Pair<>(h, i));
            } else {
                stack.pop();
                stack.push(new Pair<>(h, i));
            }
        }

        return trippedWater;
    }

    /**
     Here is my idea: instead of calculating area by height*width, we can think it in a cumulative way. In other words, sum water amount of each bin(width=1).
     Search from left to right and maintain a max height of left and right separately, which is like a one-side wall of partial container.
     Fix the higher one and flow water from the lower part. For example, if current height of left is lower, we fill water in the left bin.
     Until left meets right, we filled the whole container.
     */
    public int trapNewBi(int height[]) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int res = 0;
        int maxLeft = 0, maxRight = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    res += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    res += maxRight - height[right];
                }
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        P42_TrappingRainWater trappingRainWater_42 = new P42_TrappingRainWater();
        System.out.println(trappingRainWater_42.trap(new int[] {0, 4, 3, 2, 1, 0, 1, 3, 4, 0}));
        System.out.println(trappingRainWater_42.trap(new int[] {4, 2, 3}));
        System.out.println(trappingRainWater_42.trap(new int[] {5,5,1,7,1,1,5,2,7,6}));
        System.out.println("--------");
        System.out.println(trappingRainWater_42.trapNewBi(new int[] {0, 4, 3, 2, 1, 0, 1, 3, 4, 0}));
        System.out.println(trappingRainWater_42.trapNewBi(new int[] {4, 2, 3}));
        System.out.println(trappingRainWater_42.trapNewBi(new int[] {5,5,1,7,1,1,5,2,7,6}));
    }
}
