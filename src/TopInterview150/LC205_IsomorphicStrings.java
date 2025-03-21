package TopInterview150;

import java.util.Arrays;

/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters.
No two characters may map to the same character, but a character may map to itself.

Example 1:
Input: s = "egg", t = "add"
Output: true
Explanation:
The strings s and t can be made identical by:
Mapping 'e' to 'a'.
Mapping 'g' to 'd'.

Example 2:
Input: s = "foo", t = "bar"
Output: false
Explanation:
The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

Example 3:
Input: s = "paper", t = "title"
Output: true
 */
public class LC205_IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add")); // true
        System.out.println(isIsomorphic("foo", "bar")); // false
        System.out.println(isIsomorphic("paper", "title")); // true
        System.out.println(isIsomorphic("bbbaaaba", "aaabbbba")); // false
    }

    public static boolean isIsomorphic(String s, String t) {
        // Incorrect approach — solves a different problem.
//        char[] lettersS = new char[26];
//        char[] lettersT = new char[26];
//        for (char chS : s.toLowerCase().toCharArray()) {
//            lettersS[chS - 'a']++;
//        }
//        for (char chT : t.toLowerCase().toCharArray()) {
//            lettersT[chT - 'a']++;
//        }
//        Arrays.sort(lettersS);
//        Arrays.sort(lettersT);
//        return Arrays.equals(lettersS, lettersT);


    }
}
