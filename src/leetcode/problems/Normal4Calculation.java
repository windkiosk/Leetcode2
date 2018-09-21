package leetcode.problems;

public class Normal4Calculation {

    public static void main(String[] args) {
        Normal4Calculation normal4Calculation = new Normal4Calculation();
        System.out.println(normal4Calculation.calc("1+2*3-4+5/6*7+8-9="));
    }

    float calc(String input) {
        if (input == null || input.length() == 0) { return 0.0f; }

        float v1 = 0, v2 = 0;
        char op1 = ' ';
        char op2= ' ';

        for (char c : input.toCharArray()) {
            if (c > '0' && c <= '9') {
                int num = c - '0';

                if (v1 == 0) v1 = num;
                else if (v2 == 0) v2 = num;
                else {
                    v2 = operate(v2, num, op2);
                    op2 = ' ';
                }
            }
            else if (op1 == ' ') op1 = c;
            else if (c == '+' || c == '-' || c == '=') {
                v1 = operate(v1, v2, op1);
                op1 = c;
                v2 = 0;
            } else {
                op2 = c;
            }
        }

        return v1;
    }

    private float operate(float v2, float num, char op) {
        if (op == '/') return v2 / num;
        else if (op == '*') return v2 * num;
        else if (op == '-') return v2 - num;
        else return v2 + num;
    }
}
