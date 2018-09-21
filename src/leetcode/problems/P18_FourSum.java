package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class P18_FourSum {

    public static void main(String[] strings) {
        int[] num = new int[]{1, 0, -1, 0, -2, 2};
        P18_FourSum fourSum_18 = new P18_FourSum();
        System.out.println(fourSum_18.fourSum(num, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<Integer> intList = new ArrayList<Integer>();
        for (int index = 0; index < nums.length; index++)
        {
            intList.add(nums[index]);
        }
        return findMatchGroupForSum(intList, 4, target);
    }

    List<List<Integer>> findMatchGroupForSum(List<Integer> input, int size, int target) {
        if (input == null || input.size() < size)
            throw new IllegalArgumentException("The size of input should be larger than size argument");

        List<List<Integer>> ret = new ArrayList<>();

        if (size == 0) return ret;

        for (int i = 0; i < (input.size() - size); i ++) {
            final Integer integer = input.get(i);
            List<List<Integer>> tmp = findMatchGroupForSum(input.subList(1, input.size()), size - 1, target - integer);
            if (tmp.size() > 0) {
                for (int j = 0; j < tmp.size(); j ++) {
                    final List<Integer> l = tmp.get(i);
                    l.add(0, integer);
                    ret.add(l);
                }
            }
        }

        return ret;
    }
}
