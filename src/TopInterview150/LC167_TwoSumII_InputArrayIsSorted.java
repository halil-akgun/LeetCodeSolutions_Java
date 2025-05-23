package TopInterview150;

import java.util.Arrays;

/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
find two numbers such that they add up to a specific target number. Let these two numbers be
numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array
[index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

Example 1:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Example 2:
Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

Example 3:
Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 */
public class LC167_TwoSumII_InputArrayIsSorted {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9))); // [1, 2]
        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6))); // [1, 3]
        System.out.println(Arrays.toString(twoSum(new int[]{-1, 0}, -1))); // [1, 2]
    }

    public static int[] twoSum(int[] numbers, int target) {
        // way 1 (Recursive Approach - May Cause StackOverflowError for Large Inputs)
//        return helperMethod(numbers, target, 0, 1);

        // way 2
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target)
                return new int[]{left + 1, right + 1};
            else if (sum > target)
                right--;
            else
                left++;
        }

        return new int[]{-1, -1};
    }

    private static int[] helperMethod(int[] numbers, int target, int index1, int index2) {
        if (numbers[index1] + numbers[index2] == target)
            return new int[]{index1 + 1, index2 + 1};

        index2++;

        if (index2 > numbers.length - 1) {
            index1++;
            index2 = index1 + 1;
        }

        return helperMethod(numbers, target, index1, index2);
    }
}
