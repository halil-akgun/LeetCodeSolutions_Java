package TopInterview150;

import java.util.Arrays;

/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */
public class LC238_ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4}))); // [24,12,8,6]
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3}))); // [0,0,9,0,0]
    }

    public static int[] productExceptSelf(int[] nums) {
        // way 1
//        int[] result = new int[nums.length];
//        int countOfZero = (int) Arrays.stream(nums).filter(t -> t == 0).count();
//
//        if (countOfZero > 1) {
//            return result;
//        } else if (countOfZero == 1) {
//            int multiply = Arrays.stream(nums).filter(t -> t != 0).reduce((a, b) -> a * b).getAsInt();
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i] == 0) {
//                    result[i] = multiply;
//                } else {
//                    result[i] = 0;
//                }
//            }
//        } else {
//            int multiply = Arrays.stream(nums).reduce((a, b) -> a * b).getAsInt();
//            for (int i = 0; i < nums.length; i++) {
//                result[i] = multiply / nums[i];
//            }
//        }
//
//        return result;

        // way 2
        int n = nums.length;
        int[] result = new int[n];

        // First calculate the left products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Then update the result by calculating the products from the right
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }
}
