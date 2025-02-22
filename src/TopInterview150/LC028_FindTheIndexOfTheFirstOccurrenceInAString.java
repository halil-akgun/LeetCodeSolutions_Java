package TopInterview150;

/*
Given two strings needle and haystack, return the index of the first occurrence of
needle in haystack, or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 */
public class LC028_FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad")); // 0
        System.out.println(strStr("leetcode", "leeto")); // -1
        System.out.println(strStr("mississippi", "issip")); // 4
    }

    public static int strStr(String haystack, String needle) {
        // way 1 - Uses substring() and startsWith(), which creates new String objects and is less efficient
//        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
//            if (haystack.substring(i).startsWith(needle))
//                return i;
//        }
//        return -1;

        // way 2 - Iterates through the string, compares characters one by one using charAt()
//        boolean broken;
//        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
//            broken = false;
//            if (haystack.charAt(i) == needle.charAt(0)) {
//                for (int j = 1; j < needle.length(); j++) {
//                    if (haystack.charAt(i + j) != needle.charAt(j)) {
//                        broken = true;
//                        break;
//                    }
//                }
//                if (!broken)
//                    return i;
//            }
//        }
//        return -1;

        // way 3 - Converts strings to char arrays for faster access and avoids method calls like charAt()
        char[] haystackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();
        boolean broken;
        for (int i = 0; i < haystackArr.length - needleArr.length + 1; i++) {
            broken = false;
            if (haystackArr[i] == needleArr[0]) {
                for (int j = 1; j < needleArr.length; j++) {
                    if (haystackArr[i + j] != needleArr[j]) {
                        broken = true;
                        break;
                    }
                }
                if (!broken)
                    return i;
            }
        }
        return -1;
    }
}
