package TopInterview150;

/*
You are given an integer array nums. You are initially positioned at the array's first index,
and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0,
which makes it impossible to reach the last index.
 */
public class LC055_JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4})); // true
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4})); // false
        System.out.println(canJump(new int[]{2, 0, 0})); // true
    }

    public static boolean canJump(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (checkPreviousJumps(nums, i)) {
                    continue;
                } else {
                    return i >= nums.length - 1;
                }
            }
            nums[i]--;
        }
        return true;
    }

    private static boolean checkPreviousJumps(int[] nums, int i) {
        for (int j = i - 1; j >= 0; j--) {
            if (nums[j] >= i - j) return true;
        }
        return false;
    }
}
