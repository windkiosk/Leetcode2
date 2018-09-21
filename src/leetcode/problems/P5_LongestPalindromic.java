package leetcode.problems;

public class P5_LongestPalindromic {

    public static void main(String[] args) {
        String s = "bananas";
        P5_LongestPalindromic longestPalindromic = new P5_LongestPalindromic();
        System.out.println(longestPalindromic.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        if (s == null) return "";
        if (s.length() < 2) return s;

        String ret = s.substring(0, 1);
        int max = 1;
        int len = s.length();

        boolean[][] array = new boolean[len+1][len];
        for (int i = 0; i < len; i ++) {
            array[0][i] = true;
            array[1][i] = true;
        }
        for (int span = 2; span <= len; span ++) {
            for (int start = 0; start <= len - span; start ++) {
                if (s.charAt(start) == s.charAt(start + span - 1)
                        && array[span - 2][start + 1]) {
                    array[span][start] = true;
                    if (max < span) {
                        max = span;
                        ret = s.substring(start, start + span);
                    }
                }
            }
        }
        return ret;
    }
}
