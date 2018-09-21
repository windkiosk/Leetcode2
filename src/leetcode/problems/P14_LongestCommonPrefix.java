package leetcode.problems;

public class P14_LongestCommonPrefix {

    public static void main(String[] args) {

        P14_LongestCommonPrefix p14_longestCommonPrefix = new P14_LongestCommonPrefix();
//        System.out.println(p14_longestCommonPrefix.longestCommonPrefix(new String[]{"flower","flow","flight"}));
//        System.out.println(p14_longestCommonPrefix.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(p14_longestCommonPrefix.longestCommonPrefix(new String[]{}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        StringBuilder stringBuilder = new StringBuilder("");

        int index = 0;
        boolean isDone = false;
        while (true) {
            Character c = null;
            for (String str : strs) {
                if (index >= str.length()) {
                    isDone = true;
                    break;
                }
                if (c == null) {
                    c = str.charAt(index);
                } else {
                    char curr = str.charAt(index);
                    if (!c.equals(curr)) {
                        isDone = true;
                        break;
                    }
                }
            }
            if (isDone) {
                break;
            }
            stringBuilder.append(c);
            index ++;
        }

        return stringBuilder.toString();
    }
}
