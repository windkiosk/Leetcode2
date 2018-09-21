package leetcode.problems;

import java.util.Arrays;

public class P280_WiggleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3,5,2,1,6,4};
//        int[] nums = new int[]{3, 1, 2};
        P280_WiggleSort p280_wiggleSort = new P280_WiggleSort();
        p280_wiggleSort.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        boolean isUp = true;
        int last = nums[0];
        for (int i = 1 ; i < nums.length ; i ++) {
            if((isUp && last > nums[i]) || (!isUp && last < nums[i])) {
                swap(nums, i, i - 1);
            }
            last = nums[i];
            isUp = !isUp;
        }
    }

    void swap(int[] nums, int i0, int i1) {
        int temp = nums[i0];
        nums[i0] = nums[i1];
        nums[i1] = temp;
    }
}
