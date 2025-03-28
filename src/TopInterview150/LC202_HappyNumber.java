package TopInterview150;

/*
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:
 - Starting with any positive integer, replace the number by the sum of the squares of its digits.
 - Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 - Those numbers for which this process ends in 1 are happy.

Return true if n is a happy number, and false if not.

Example 1:
Input: n = 19
Output: true
Explanation:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1

Example 2:
Input: n = 2
Output: false
 */
public class LC202_HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19)); // true
        System.out.println(isHappy(2)); // false
    }

    public static boolean isHappy(int n) {
        // way 1
        for (int i = 0; i < 100; i++) {
            n = a(n);
            if (n == 1)
                return true;
        }
        return false;

        // way 2
//        if (n == 1 || n == 7) return true;
//        else if (n < 10) return false;
//        else {
//            int sum = 0;
//            while (n > 0) {
//                int temp = n % 10;
//                sum += temp * temp;
//                n = n / 10;
//            }
//            return isHappy(sum);
//        }
    }

    private static int a(int n) {
        int z = 0;
        while (n > 0) {
            z += (int) Math.pow(n % 10, 2);
            n = n / 10;
        }
        return z;
    }
}
