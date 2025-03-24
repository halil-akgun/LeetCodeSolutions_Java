package TopInterview150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:
 - Each letter in pattern maps to exactly one unique word in s.
 - Each unique word in s maps to exactly one letter in pattern.
 - No two letters map to the same word, and no two words map to the same letter.

Example 1:
Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Explanation:
The bijection can be established as:
- 'a' maps to "dog".
- 'b' maps to "cat".

Example 2:
Input: pattern = "abba", s = "dog cat cat fish"
Output: false

Example 3:
Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
 */
public class LC290_WordPattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog")); // true
        System.out.println(wordPattern("abba", "dog cat cat fish")); // false
        System.out.println(wordPattern("aaaa", "dog cat cat dog")); // false
        System.out.println(wordPattern("abba", "dog dog dog dog")); // false
    }

    public static boolean wordPattern(String pattern, String s) {
        char[] patternChars = pattern.toCharArray();
        String[] words = s.split(" ");

        if (patternChars.length != words.length) return false;

        Map<Character, String> charToWordMap = new HashMap<>();
        Set<String> usedWords = new HashSet<>();

        for (int i = 0; i < patternChars.length; i++) {
            char ch = patternChars[i];
            String str = charToWordMap.get(ch);
            if (str != null) {
                if (!str.equals(words[i]))
                    return false;
            } else {
                if (usedWords.contains(words[i]))
                    return false;
                else {
                    usedWords.add(words[i]);
                    charToWordMap.put(ch, words[i]);
                }
            }
        }

        return true;
    }
}
