package leetcode.problems;

public class P263_UglyNumber {

    public static void main(String[] args) {
        P263_UglyNumber uglyNumber_263 = new P263_UglyNumber();

        System.out.println(uglyNumber_263.isUgly(2));
    }

    private boolean isUgly(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;

        while (true) {
            if (num % 2 == 0) {
                num = num / 2;
            } else if (num % 3 == 0) {
                num = num / 3;
            } else if (num % 5 == 0) {
                num = num / 5;
            } else {
                return false;
            }

            if (num < 2) {
                return true;
            }
        }
    }
}
