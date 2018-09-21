package leetcode.problems;

public class P91_DecodeWays {

    public static void main(String[] args) {
        P91_DecodeWays decodeWays_91 = new P91_DecodeWays();
        System.out.println(decodeWays_91.numDecodings_recursive_memo("226"));
        System.out.println(decodeWays_91.numDecodings_recursive_memo("100"));
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;

        int length = s.length();
        int[] ret = new int[length + 1];
        ret[0] = 1;

        for (int i = 0; i < length; i ++ ) {
            int c = s.charAt(i) - 48;
            int last = (i > 0) ? (s.charAt(i - 1) - 48) : 0;
            if (c == 0) {
                if (last > 2 || last == 0) {
                    return 0;
                } else {
                    ret[i + 1] = ret[i - 1];
                }
            } else {
                if (last > 0 && (last * 10 + c <= 26)) {
                    ret[i + 1] = ret[i - 1] + ret[i];
                } else {
                    ret[i + 1] = ret[i];
                }
            }
        }
        return ret[length];
    }

    public int numDecodings_recursive(String s) {
        return helper(s, 0);
    }

    public int helper(String s, int pos) {
        if (pos >= s.length()) return 1;

        int c = s.charAt(pos) - 48;
        if (c == 0) {
            return 0;
        } else {
            if (pos < s.length() - 1) {
                int next = s.charAt(pos + 1) - 48;
                if (c * 10 + next <= 26) {
                    return helper(s, pos + 1) + helper(s, pos + 2);
                }
            }
            return helper(s, pos + 1);
        }
    }

    public int numDecodings_recursive_memo(String s) {
        int[] memo = new int[s.length()];
        for (int i = 0 ; i < memo.length ; i ++) {
            memo[i] = -1;
        }
        return helper_memo(s, 0, memo);
    }

    public int helper_memo(String s, int pos, int[] memo) {
        if (pos >= s.length()) return 1;

        if (memo[pos] >= 0) return memo[pos];

        int ret;
        int c = s.charAt(pos) - 48;
        if (c == 0) {
            ret = 0;
        } else {
            if (pos < s.length() - 1) {
                int next = s.charAt(pos + 1) - 48;
                if (c * 10 + next <= 26) {
                    ret = helper_memo(s, pos + 1, memo) + helper_memo(s, pos + 2, memo);
                    memo[pos] = ret;
                    return ret;
                }
            }
            ret = helper_memo(s, pos + 1, memo);
        }
        memo[pos] = ret;
        return ret;
    }
}
