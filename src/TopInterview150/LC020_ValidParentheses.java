package TopInterview150;

import java.util.Stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
 - Open brackets must be closed by the same type of brackets.
 - Open brackets must be closed in the correct order.
 - Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true
 */
public class LC020_ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()")); // true
        System.out.println(isValid("()[]{}")); // true
        System.out.println(isValid("(]")); // false
        System.out.println(isValid("([])")); // true
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (isOpen(ch)) {
                stack.add(ch);
            } else {
                try {
                    char c = stack.pop();
                    if (!check(c, ch))
                        return false;
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean check(char c, char ch) {
        return c == '(' && ch == ')' || c == '[' && ch == ']' || c == '{' && ch == '}';
    }

    private static boolean isOpen(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }
}
