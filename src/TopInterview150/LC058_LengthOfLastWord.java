package TopInterview150;

/*
Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.

Example 1:
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

Example 2:
Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

Example 3:
Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.
 */
public class LC058_LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World")); // 5
        System.out.println(lengthOfLastWord("   fly me   to   the moon  ")); // 4
        System.out.println(lengthOfLastWord("luffy is still joyboy")); // 6
        System.out.println(lengthOfLastWord("a")); // 1

    }

    public static int lengthOfLastWord(String s) {
        // way 1
//        String[] a = s.trim().split(" ");
//        return a[a.length - 1].length();

        // way 2
//        s = s.trim();
//        int result = 0;
//        for (int i = s.length() - 1; i >= 0; i--) {
//            if (s.charAt(i) != ' ')
//                result++;
//            else
//                break;
//        }
//        return result;

        // way 3
        int n = s.length();
        int count = 0;
        while (s.charAt(n - 1) == ' ') {
            n--;
        }
        while (n > 0 && s.charAt(n - 1) != ' ') {
            count++;
            n--;
        }
        return count;
    }
}
