package TopInterview150;

import java.util.HashSet;
import java.util.Set;

/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j
in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 */
public class LC219_ContainsDuplicateII {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3)); // true
        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1)); // true
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2)); // false
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        // way 1
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length && j <= i + k; j++) {
//                if (nums[i] == nums[j])
//                    return true;
//            }
//        }
//        return false;

        // way 2 - Sliding window with HashSet: O(n) time complexity
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k)
                set.remove(nums[i - k - 1]);
            if (!set.add(nums[i]))
                return true;
        }
        return false;
    }
}
