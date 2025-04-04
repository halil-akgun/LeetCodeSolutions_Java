package TopInterview150;

/*
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words.
The returned string should only have a single space separating the words. Do not include any extra spaces.

Example 1:
Input: s = "the sky is blue"
Output: "blue is sky the"

Example 2:
Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:
Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */
public class LC151_ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue")); // blue is sky the
        System.out.println(reverseWords("  hello world  ")); // world hello
        System.out.println(reverseWords("a good   example")); // example good a
    }

    public static String reverseWords(String s) {
        s = " " + s;
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                for (int j = i - 1; j >= 0; j--) {
                    if (s.charAt(j) == ' ' || j == 0) {
                        result.append(s, j + 1, i + 1).append(" ");
                        i = j;
                        break;
                    }
                }
            }
        }
        return result.substring(0, result.length() - 1);
    }
}
