package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class P1_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        // key - num value, value - position currentIndex.
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            int v = nums[i];
            int other_v = target - v;
            if (map.containsKey(other_v)) {
                ret[0] = i;
                ret[1] = map.get(other_v);
                break;
            } else {
                map.put(v, i);
            }
        }
        return ret;
    }
}
