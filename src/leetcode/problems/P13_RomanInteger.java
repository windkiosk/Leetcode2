package leetcode.problems;

/**
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class P13_RomanInteger {

    public static void main(String[] args) {
        P13_RomanInteger p13_romanInteger = new P13_RomanInteger();
        System.out.println(p13_romanInteger.romanToInt("III"));
        System.out.println(p13_romanInteger.romanToInt("IV"));
        System.out.println(p13_romanInteger.romanToInt("IX"));
        System.out.println(p13_romanInteger.romanToInt("LVIII"));
        System.out.println(p13_romanInteger.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        int ret = 0;

        char lastChar = '0';
        for (int i = 0 ; i < s.length() ; i ++) {
            char c = s.charAt(i);

            switch (c) {
                case 'I':
                    ret ++;
                    break;
                case 'V':
                    ret += 5;
                    if (lastChar == 'I') {
                        ret -= 2;
                    }
                    break;
                case 'X':
                    ret += 10;
                    if (lastChar == 'I') {
                        ret -= 2;
                    }
                    break;
                case 'L':
                    ret += 50;
                    if (lastChar == 'X') {
                        ret -= 20;
                    }
                    break;
                case 'C':
                    ret += 100;
                    if (lastChar == 'X') {
                        ret -= 20;
                    }
                    break;
                case 'D':
                    ret += 500;
                    if (lastChar == 'C') {
                        ret -= 200;
                    }
                    break;
                case 'M':
                    ret += 1000;
                    if (lastChar == 'C') {
                        ret -= 200;
                    }
                    break;
            }
            lastChar = c;
        }

        return ret;
    }
}
