package TopInterview150;

/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
and removing all non-alphanumeric characters, it reads the same forward and backward.
Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 */
public class LC125_ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car")); // false
        System.out.println(isPalindrome(" ")); // true
    }

    public static boolean isPalindrome(String s) {
        // way 1
//        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
//        return new StringBuilder(s.substring(s.length() % 2 == 0 ? s.length() / 2 : s.length() / 2 + 1)).reverse().toString().equals(s.substring(0, s.length() / 2));

        // way 2
//        char[] strArr = s.toLowerCase().replaceAll("[^a-z0-9]", "").toCharArray();
//        for (int i = 0; i < strArr.length; i++) {
//            if (strArr[i] != strArr[strArr.length - 1 - i])
//                return false;
//        }
//        return true;

        // way 3
        char[] strArr = s.toLowerCase().toCharArray();
        int left = 0;
        int right = strArr.length - 1;
        while (left < right) {
            while (!(strArr[left] >= 'a' && strArr[left] <= 'z' || strArr[left] >= '0' && strArr[left] <= '9')) {
                left++;
                if (left > right)
                    return true;
            }
            while (!(strArr[right] >= 'a' && strArr[right] <= 'z' || strArr[right] >= '0' && strArr[right] <= '9')) {
                right--;
                if (right < left)
                    return true;
            }
            if (strArr[left] != strArr[right])
                return false;
            left++;
            right--;
        }
        return true;
    }
}
