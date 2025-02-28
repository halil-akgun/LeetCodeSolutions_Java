package TopInterview150;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such
that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 */
public class LC015_3Sum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4})); // [[-1,-1,2],[-1,0,1]]
        System.out.println(threeSum(new int[]{0, 1, 1})); // []
        System.out.println(threeSum(new int[]{0, 0, 0})); // [[0,0,0]]
        System.out.println(threeSum(new int[]{-1,0,1})); // [[-1,0,1]]
    }

    static List<List<Integer>> result = new ArrayList<>();
    static StringBuilder a = new StringBuilder();

    public static List<List<Integer>> threeSum(int[] nums) {
        result.clear();
        a = new StringBuilder();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        System.out.println("*************");
                        helperMethod(nums[i], nums[j], nums[k]);
                    }
                }
            }
        }
        return result;
    }

    private static void helperMethod(int i, int j, int k) {
        int min, mid, max;

        if (i < j) {
            if (i < k) {
                min = i;
                if (j < k) {
                    mid = j;
                    max = k;
                } else {
                    mid = k;
                    max = j;
                }
            } else {
                min = k;
                mid = i;
                max = j;
            }
        } else {
            if (j < k) {
                min = j;
                if (i < k) {
                    mid = i;
                    max = k;
                } else {
                    mid = k;
                    max = i;
                }
            } else {
                min = k;
                mid = j;
                max = i;
            }
        }

        a.append("_").append(min).append(",").append(mid).append(",").append(max).append("_");
        if (a.indexOf("_" + min + "," + mid + "," + max + "_") != a.lastIndexOf("_" + min + "," + mid + "," + max + "_"))
            return;

        result.add(new ArrayList<>());
        result.getLast().add(min);
        result.getLast().add(mid);
        result.getLast().add(max);
    }
}
