package leetcode.problems;

public class P136_SingleNumber {

    public static void main(String[] strings) {
        P136_SingleNumber singleNumber136 = new P136_SingleNumber();
        System.out.println(singleNumber136.singleNumber(new int[]{3, 5, 5, 0, 0, 6, 6}));
    }

    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int i : nums) {
            ret ^= i;
        }
        return ret;
    }
}
