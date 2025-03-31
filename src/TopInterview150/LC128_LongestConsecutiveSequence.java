package TopInterview150;

import java.util.Arrays;

/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

Example 3:
Input: nums = [1,0,1,2]
Output: 3
 */
public class LC128_LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2})); // 4
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1})); // 9
        System.out.println(longestConsecutive(new int[]{1, 0, 1, 2})); // 3
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int longest = 0;
        int a = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                a++;
            } else if (nums[i] != nums[i - 1]) {
                longest = Math.max(longest, a);
                a = 1;
            }
        }
        return Math.max(longest, a);
    }
}
