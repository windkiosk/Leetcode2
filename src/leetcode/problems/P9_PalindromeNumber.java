package leetcode.problems;

import java.util.Stack;

public class P9_PalindromeNumber {

    public static void main(String[] args) {
        P9_PalindromeNumber p9_palindromeNumber = new P9_PalindromeNumber();
        System.out.println(p9_palindromeNumber.isPalindrome(1000000001));
//        System.out.println(p9_palindromeNumber.isPalindrome(121));
//        System.out.println(p9_palindromeNumber.isPalindrome(12121));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return  true;

        int size = 1;
        int bit = 1;
        int curr;
        do {
            size *= 10;
            bit ++;
            curr = x / size;
        } while (curr >= 10);
        int left = bit, right = 1;
        while (left > right) {
            int r = x % 10;
            int l = x / size;
            if (r != l) return false;
            x = x - l * size;
            x = x / 10;
            size = size / 100;
            left --;
            right ++;
            if (x == 0) break;
        }

        return true;
    }
}
