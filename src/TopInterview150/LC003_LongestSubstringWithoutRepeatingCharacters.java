package TopInterview150;

/*
Given a string s, find the length of the longest substring without duplicate characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LC003_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(lengthOfLongestSubstring("bbtablud")); // 6
        System.out.println(lengthOfLongestSubstring(" ")); // 1
    }

    public static int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int left = 0;
        for (int right = 1; right < s.length(); right++) {
            if (!s.substring(left, right).contains(s.substring(right, right + 1))) {
                longest = Math.max(longest, right - left + 1);
            } else {
                left = s.substring(left, right + 1).indexOf(s.charAt(right)) + 1 + left;
                right--;
            }
        }
        return s.length() == 1 ? 1 : longest;
    }
}
