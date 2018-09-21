package leetcode.problems;

public class HopperTower {

    public static void main(String[] args) {
        HopperTower hopperTower = new HopperTower();
        System.out.println(hopperTower.isHopperable(new int[]{4, 2, 0, 0, 0, 0}));
    }

    boolean isHopperable(int[] nums) {
        int curr = 0;
        int right = 1;

        while (curr <= right) {
            int val = nums[curr];
            if (curr + val > right) {
                right = curr + val;
            }
            if (right >= nums.length) {
                return true;
            }
            curr ++;
        }

        return false;
    }
}
