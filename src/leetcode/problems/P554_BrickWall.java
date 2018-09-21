package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class P554_BrickWall {

    public static void main(String[] strings) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1,2,2,1));
        lists.add(Arrays.asList(3,1,2));
        lists.add(Arrays.asList(1,3,2));
        lists.add(Arrays.asList(2,4));
        lists.add(Arrays.asList(3,1,2));
        lists.add(Arrays.asList(1,3,1,1));

        P554_BrickWall brickWall554 = new P554_BrickWall();
        System.out.println(brickWall554.leastBricks(lists));
    }

    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) return -1;

        HashMap<Integer, Integer> map = new HashMap<>();

        int max = 0;
        for (List<Integer> row: wall) {
            int current = 0;
            for (int i = 0 ; i < row.size() - 1 ; i ++) {
                current += row.get(i);
                final Integer integer = map.get(current);
                int val = integer == null ? 1 : (integer + 1);
                map.put(current, val);
                if (val > max) max = val;
            }
        }

        return wall.size() - max;
    }
}
