package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class P822_CardFlipping {

    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> same = new HashSet();
        for (int i = 0; i < fronts.length; ++i)
            if (fronts[i] == backs[i])
                same.add(fronts[i]);

        int ans = Integer.MAX_VALUE;
        for (int x: fronts)
            if (!same.contains(x))
                ans = Math.min(ans, x);

        for (int x: backs)
            if (!same.contains(x))
                ans = Math.min(ans, x);

        return ans == Integer.MAX_VALUE ? 0 :ans;
    }

    public static void main(String[] args) {
        P822_CardFlipping cardFlipping_822 = new P822_CardFlipping();
        System.out.println(cardFlipping_822.flipgame(new int[]{1,2,4,4,7}, new int[]{1,3,4,1,3}));
    }
}
