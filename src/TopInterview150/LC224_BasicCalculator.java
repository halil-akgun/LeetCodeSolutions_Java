package TopInterview150;

import java.util.Stack;

/*
Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

Example 1:
Input: s = "1 + 1"
Output: 2

Example 2:
Input: s = " 2-1 + 2 "
Output: 3

Example 3:
Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23
 */
public class LC224_BasicCalculator {
    public static void main(String[] args) {
        System.out.println(calculate("1 + 1")); // 2
        System.out.println(calculate(" 2-1 + 2 ")); // 3
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)")); // 23
        System.out.println(calculate("1-(     -2)")); // 3
        System.out.println(calculate("(5-(1+(5)))")); // -1
        System.out.println(calculate("-(-2)+4")); // 6
    }

    public static int calculate(String s) {
        int result = 0;
        int sign = 1;
        int number = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop(); // sign
                result += stack.pop(); // result before "("
            }
        }
        result += sign * number;
        return result;
    }

    public static int calculate2(String s) { // bad solution
        s = s.replaceAll(" ", "");
        Stack<Integer> openParenthesisStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openParenthesisStack.add(i);
            } else if (s.charAt(i) == ')') {
                int start = openParenthesisStack.pop();
                int innerResult = evaluate(s.substring(start + 1, i));
                StringBuilder newExpression = getNewExpression(s, innerResult, start);
                int newEndIndex = newExpression.length() - 1;
                if (i < s.length() - 1)
                    newExpression.append(s.substring(i + 1));
                i = newEndIndex;
                s = newExpression.toString();
            }
        }
        return evaluate(s);
    }

    private static StringBuilder getNewExpression(String s, int innerResult, int start) {
        StringBuilder newExpression;
        if (innerResult < 0) {
            if (start != 0 && s.charAt(start - 1) == '-') {
                newExpression = new StringBuilder(s.substring(0, start - 1) + "+" + innerResult*-1);
            } else if (start != 0) {
                newExpression = new StringBuilder(s.substring(0, start - 1) + innerResult);
            } else {
                newExpression = new StringBuilder("" + innerResult);
            }
        } else {
            newExpression = new StringBuilder(s.substring(0, start) + innerResult);
        }
        return newExpression;
    }

    private static int evaluate(String str) {
        int sum = 0;
        int startIndex = 0;
        char ch = str.charAt(0);

        for (int i = ch == '-' || ch == '+' ? 1 : 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar == '+' || currentChar == '-') {
                sum += Integer.parseInt(str.substring(startIndex, i));
                startIndex = i;
            }
        }

        sum += Integer.parseInt(str.substring(startIndex));
        return sum;
    }
}
