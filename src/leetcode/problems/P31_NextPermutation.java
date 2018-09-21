package leetcode.problems;

import java.util.Arrays;

public class P31_NextPermutation {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 2, 4, 3};
        P31_NextPermutation nextPermutation = new P31_NextPermutation();
        nextPermutation.nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }

    public void nextPermutation(int[] nums) {
        if (nums.length == 1) return;

        int left = 0;
        for (int i = nums.length - 2; i >= 0; i --) {
            if (nums[i] < nums[i + 1]) {
                left = i + 1;

                for (int j = nums.length - 1; j > i; j --) {
                    // switch
                    if (nums[j] > nums[i]) {
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        break;
                    }
                }
                break;
            }
        }

        reverse(nums, left);
    }

    void reverse(int[] nums, int left) {
        if (left == nums.length - 1) return;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left ++;
            right --;
        }
    }
}
