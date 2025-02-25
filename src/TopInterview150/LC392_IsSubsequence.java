package TopInterview150;

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some
(can be none) of the characters without disturbing the relative positions of the remaining characters.
(i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false
 */
public class LC392_IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc")); // true
        System.out.println(isSubsequence("axc", "ahbgdc")); // false
        System.out.println(isSubsequence("", "ahbgdc")); // true
    }

    public static boolean isSubsequence(String s, String t) {

        if (s.isEmpty())
            return true;

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int idx = 0;
        for (char tChar : tChars) {
            if (tChar == sChars[idx]) {
                if (idx == sChars.length - 1)
                    return true;
                idx++;
            }
        }

        return false;
    }
}
