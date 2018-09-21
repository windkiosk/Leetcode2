package leetcode.problems;

public class P7_ReverseInteger {

    public static void main(String[] args) {
        P7_ReverseInteger p7_reverseInteger = new P7_ReverseInteger();
        System.out.println(p7_reverseInteger.reverse(120));
    }

    public int reverse(int x) {
        if (x == 0) return 0;
        boolean isNegtive = false;
        if (x < 0) isNegtive = true;

        long val = x;
        val = val > 0 ? val : (-val);
        long ret = 0;

        while (val > 0) {
            long mod = val % 10;
            ret = ret * 10 + mod;
            val = val / 10;
        }

        ret = isNegtive ? (-ret) : ret;

        if (ret < Integer.MIN_VALUE || ret > Integer.MAX_VALUE) return 0;
        return (int)ret;
    }

    public int reverseNoFlag(int x)
    {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }
}
