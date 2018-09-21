package leetcode.problems;

public class P557_ReverseWords {

    public static void main(String[] strings) {
        P557_ReverseWords reverseWords557 = new P557_ReverseWords();
        System.out.println(reverseWords557.reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 1) return s;

        final String[] split = s.split(" ");

        StringBuilder builder = new StringBuilder();
        for (String str : split) {
            builder.append(reverse(str));
            builder.append(' ');
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    private char[] reverse(String str) {
        final char[] chars = str.toCharArray();
        int low = 0;
        int high = chars.length - 1;
        while (low < high) {
            char c = chars[low];
            chars[low] = chars[high];
            chars[high] = c;
            low ++;
            high --;
        }
        return chars;
    }
}
