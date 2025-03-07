package TopInterview150;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such
that every character in t (including duplicates) is included in the window. If there is no such substring,
return the empty string "".

The testcases will be generated such that the answer is unique.

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 */
public class LC076_MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // "BANC"
        System.out.println(minWindow("a", "a")); // "a"
        System.out.println(minWindow("a", "aa")); // ""
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> letters = new HashMap<>();
        Map<Character, Integer> lettersDuplicate;
        int left, right, min = Integer.MAX_VALUE;
        int left2 = 0, right2 = s.length() - 1;

        for (int i = 0; i < t.length(); i++) {
            letters.put(t.charAt(i), letters.getOrDefault(t.charAt(i), 0) + 1);
        }

        lettersDuplicate = new HashMap<>(letters);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (letters.containsKey(ch)) {
                left = i;
                right = i;
                letters.put(ch, letters.get(ch) - 1);
                while (right < s.length()-1 && control(letters)) {
                    right++;
                    char ch2 = s.charAt(right);
                    if (letters.containsKey(ch2)) {
                        letters.put(ch2, letters.get(ch2) - 1);
                    }
                }
                if (right - left < min) {
                    left2 = left;
                    right2 = right;
                    min = right - left;
                }
            }
            letters = lettersDuplicate;
        }
        System.out.println(left2 + " " + right2);
        return s.substring(left2, right2);
    }

    private static boolean control(Map<Character, Integer> letters) {
        for (Integer value : letters.values()) {
            if (value > 0) return true;
        }
        return false;
    }
}
