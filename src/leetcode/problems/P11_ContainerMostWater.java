package leetcode.problems;

public class P11_ContainerMostWater {

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int water = (right - left) * Math.min(height[left], height[right]);
            if (water > max) {
                max = water;
            }

            if (height[left] < height[right]) {
                int i = left + 1;
                while (height[i] < height[left] && i < right) {
                    i ++;
                }
                left = i;
            } else {
                int i = right - 1;
                while (height[i] < height[right] && i > left) {
                    i --;
                }
                right = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        P11_ContainerMostWater containerMostWater = new P11_ContainerMostWater();
        System.out.println(containerMostWater.maxArea(new int[]{2, 3, 5, 1000, 1001, 4, 9, 12}));
    }
}
