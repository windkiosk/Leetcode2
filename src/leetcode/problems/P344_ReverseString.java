package leetcode.problems;

public class P344_ReverseString {

    public static void main(String[] strings) {
        P344_ReverseString reverseString344 = new P344_ReverseString();
        System.out.println(reverseString344.reverseString("hello"));
    }

    public String reverseString(String s) {
        if (s.length() < 2) {
            return s;
        }

        final char[] chars = s.toCharArray();
        int low = 0;
        int high = chars.length - 1;
        while (low < high) {
            char c = chars[low];
            chars[low] = chars[high];
            chars[high] = c;
            low ++;
            high --;
        }
        return new String(chars);
    }
}
