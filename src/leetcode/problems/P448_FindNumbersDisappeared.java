package leetcode.problems;

import java.util.LinkedList;
import java.util.List;

public class P448_FindNumbersDisappeared {

    public static void main(String[] args) {
        int[] a = new int[] {4, 3, 2, 7, 8, 2, 3, 1};
        P448_FindNumbersDisappeared findNumbersDisappeared_448 = new P448_FindNumbersDisappeared();
        System.out.println(findNumbersDisappeared_448.findDisappearedNumbers(a));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new LinkedList<>();
        if (nums == null || nums.length == 0) return ret;

        // switch elements to right pos.
        for (int i = 0; i < nums.length; i ++) {
            int index = i;
            int lastNum = 0;
            while (index >= 0 && nums[index] != index + 1) {
                int tmp = nums[index];
                nums[index] = lastNum;
                lastNum = tmp;
                index = lastNum - 1;
            }
        }

        // find the missing nums.
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == 0) {
                ret.add(i + 1);
            }
        }

        return ret;
    }
}
