package TopInterview150;

import java.util.Arrays;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */
public class LC014_LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"})); // fl
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"})); // ""
        System.out.println(longestCommonPrefix(new String[]{"a"})); // "a"
        System.out.println(longestCommonPrefix(new String[]{})); // ""
    }

    public static String longestCommonPrefix(String[] strs) {
        // way 1
//        if (strs.length == 0) {
//            return "";
//        }
//
//        int idx = 1;
//        while (idx <= strs[0].length()) {
//            int finalIdx = idx;
//            if (Arrays.stream(strs).allMatch(t -> t.startsWith(strs[0].substring(0, finalIdx)))) {
//                idx++;
//            } else {
//                break;
//            }
//        }
//        return strs[0].substring(0, idx - 1);

        // way 2
//        if (strs.length == 0) {
//            return "";
//        }
//
//        int idx = 1;
//        while (idx <= strs[0].length()) {
//            for (int i = 1; i < strs.length; i++) {
//                if (!strs[i].startsWith(strs[0].substring(0, idx)))
//                    return strs[0].substring(0, idx - 1);
//            }
//            idx++;
//        }
//        return strs[0].substring(0, idx - 1);

        // way 3
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];
        int prefixLength = prefix.length();

        for (String str : strs) {
            while (prefixLength > str.length() || !prefix.substring(0, prefixLength).equals(str.substring(0, prefixLength))) {
                prefixLength--;
                if (prefixLength == 0)
                    return "";
                prefix = strs[0].substring(0, prefixLength);
            }
        }

        return prefix;
    }
}
