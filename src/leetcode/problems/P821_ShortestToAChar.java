package leetcode.problems;

import java.util.Arrays;

public class P821_ShortestToAChar {

    public int[] shortestToChar(String inputStr, char character) {
        int length = inputStr.length();
        int[] ret = new int[length];
        int lastMatch = -1;
        for (int i = 0; i < length; i ++) {
            char c = inputStr.charAt(i);
            if (c == character) {
                int needUpdate;
                if (lastMatch < 0) {
                    needUpdate = i;
                } else {
                    needUpdate = (i - lastMatch - 1) / 2;
                }

                for (int j = 1; j <= needUpdate; j ++) {
                    ret[i -j] = j;
                }
                lastMatch = i;
            } else if (lastMatch >= 0) {
                ret[i] = ret[i - 1] + 1;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        P821_ShortestToAChar shortestToAChar_821 = new P821_ShortestToAChar();
        System.out.println(Arrays.toString(shortestToAChar_821.shortestToChar("loveleetcode", 'e')));
    }
}
