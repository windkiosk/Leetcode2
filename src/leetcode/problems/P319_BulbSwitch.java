package leetcode.problems;

public class P319_BulbSwitch {

    public static void main(String[] strings) {
        P319_BulbSwitch bulbSwitch319 = new P319_BulbSwitch();
        System.out.println(bulbSwitch319.bulbSwitch(5));
    }

    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
