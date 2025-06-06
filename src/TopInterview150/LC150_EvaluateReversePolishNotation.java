package TopInterview150;

import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

/*
You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:
 - The valid operators are '+', '-', '*', and '/'.
 - Each operand may be an integer or another expression.
 - The division between two integers always truncates toward zero.
 - There will not be any division by zero.
 - The input represents a valid arithmetic expression in a reverse polish notation.
 - The answer and all the intermediate calculations can be represented in a 32-bit integer.

Example 1:
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

Example 2:
Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6

Example 3:
Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 */
public class LC150_EvaluateReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"})); // 9
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"})); // 6
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"})); // 22
    }

    private static final Map<String, BiFunction<Integer, Integer, Integer>> operators = Map.of(
            "+", Integer::sum,
            "-", (a, b) -> a - b,
            "*", (a, b) -> a * b,
            "/", (a, b) -> {
                if (b == 0) {
                    throw new IllegalArgumentException();
                }
                return a / b;
            }
    );

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            var operator = operators.get(token);
            if (operator == null) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                stack.add(operator.apply(a, b));
            }
        }
        return stack.pop();
    }
}
