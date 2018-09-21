package leetcode.problems;

import java.util.Stack;

public class P20_ValidParentheses {

    public static void main(String[] args) {
        P20_ValidParentheses p20_validParentheses = new P20_ValidParentheses();
        System.out.println(p20_validParentheses.isValid("()[]{}"));
        System.out.println(p20_validParentheses.isValid("(]"));
        System.out.println(p20_validParentheses.isValid("([)]"));
        System.out.println(p20_validParentheses.isValid("{[]}"));
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (!checkAndPop(stack, '(')) {
                        return false;
                    }
                    break;
                case '}':
                    if (!checkAndPop(stack, '{')) {
                        return false;
                    }
                    break;
                case ']':
                    if (!checkAndPop(stack, '[')) {
                        return false;
                    }
                    break;
            }
        }

        return stack.isEmpty();
    }

    public boolean checkAndPop(Stack<Character> stack, char c) {
        if (stack.isEmpty()) return false;
        char top = stack.peek();
        if (top == c) {
            stack.pop();
        } else {
            return false;
        }
        return true;
    }

    public boolean isValidNice(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
