package leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;

public class P403_FrogJump {

    public static void main(String[] args) {
        P403_FrogJump frogJump403 = new P403_FrogJump();
        System.out.println(frogJump403.canCross(new int[]{0,1,3,5,6,8,12,17}));
        System.out.println(frogJump403.canCross(new int[]{0,1,2,3,4,8,9,11}));
        System.out.println(frogJump403.canCross(new int[]{0,2}));

        System.out.println(frogJump403.canCross2(new int[]{0,1,3,5,6,8,12,17}));
        System.out.println(frogJump403.canCross2(new int[]{0,1,2,3,4,8,9,11}));
        System.out.println(frogJump403.canCross2(new int[]{0,2}));
    }

    public boolean canCross2(int[] stones) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }

    public boolean canCross(int[] stones) {
        if (stones.length == 2) {
            if (stones[1] == 1) {
                return true;
            } else {
                return false;
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int stone : stones) {
            set.add(stone);
        }

        int lastStone = stones[stones.length - 1];
        LinkedList<Step> queue = new LinkedList<>();
        queue.add(new Step(1, 1));

        HashSet<Step> stepSets = new HashSet<>();
        stepSets.add(new Step(1, 1));

        while (!queue.isEmpty()) {
            Step step = queue.pop();

            int index = step.currentIndex;
            int index0 = index + step.lastStep - 1;
            int index1 = index + step.lastStep;
            int index2 = index + step.lastStep + 1;

            if (index0 == lastStone || index1 == lastStone || index2 == lastStone) return true;

            if (index0 != index && set.contains(index0)) {
                Step newStep = new Step(index0, step.lastStep - 1);
                if (!stepSets.contains(newStep)) {
                    queue.add(newStep);
                    stepSets.add(newStep);
                }
            }

            if (set.contains(index1)) {
                Step newStep = new Step(index1, step.lastStep);
                if (!stepSets.contains(newStep)) {
                    queue.add(newStep);
                    stepSets.add(newStep);
                }
            }

            if (set.contains(index2)) {
                Step newStep = new Step(index2, step.lastStep + 1);
                if (!stepSets.contains(newStep)) {
                    queue.add(newStep);
                    stepSets.add(newStep);
                }
            }
        }

        return false;
    }

    private static class Step {
        int currentIndex;
        int lastStep;

        public Step(int currentIndex, int lastStep) {
            this.currentIndex = currentIndex;
            this.lastStep = lastStep;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) { return true; }
            if (o == null || getClass() != o.getClass()) { return false; }
            Step step = (Step) o;
            return currentIndex == step.currentIndex &&
                    lastStep == step.lastStep;
        }

        @Override
        public int hashCode() {
            return Objects.hash(currentIndex, lastStep);
        }
    }
}
