package TopInterview150;

import java.util.Arrays;

/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using
the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true
 */
public class LC383_RansomNote {
    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b")); // false
        System.out.println(canConstruct("aa", "ab")); // false
        System.out.println(canConstruct("aa", "aab")); // true
        System.out.println(canConstruct("fihjjjjei", "hjibagacbhadfaefdjaeaebgi")); // false
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        // way 1
//        String r = ransomNote;
//        String m = magazine;
//
//        while (!ransomNote.isEmpty()) {
//            magazine = magazine.replaceAll(ransomNote.charAt(0) + "", "");
//            ransomNote = ransomNote.replaceAll(ransomNote.charAt(0) + "", "");
//            if (r.length() - ransomNote.length() > m.length() - magazine.length())
//                return false;
//            r = ransomNote;
//            m = magazine;
//        }
//
//        return true;

        // way 2
//        char[] r = ransomNote.toCharArray();
//        char[] m = magazine.toCharArray();
//        Arrays.sort(r);
//        Arrays.sort(m);
//        int i = 0, j = 0;
//        while (i < r.length && j < m.length) {
//            if (r[i] < m[j])
//                break;
//            if (r[i] == m[j])
//                i++;
//            j++;
//        }
//        return i == r.length;

        // way 3
        int[] alphabet = new int[26];
        for (char c : ransomNote.toCharArray()) {
            int i = magazine.indexOf(c, alphabet[c % 26]);
            if (i == -1) return false;
            alphabet[c % 26] = i + 1;
        }
        return true;
    }
}
