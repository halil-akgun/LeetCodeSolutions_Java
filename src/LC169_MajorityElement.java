import java.util.Arrays;
import java.util.HashMap;

/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */
public class LC169_MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3})); // 3
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2})); // 2
    }

    public static int majorityElement(int[] nums) {

        // way 1
//        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
//        int majorityElement = 0;
//        int maxFrequency = 0;
//
//        for (int num : nums) {
//            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
//
//            if (frequencyMap.get(num) > maxFrequency) {
//                majorityElement = num;
//                maxFrequency = frequencyMap.get(num);
//            }
//        }
//
//        return majorityElement;

        // way 2
         Arrays.sort(nums);
         return nums[nums.length / 2];
    }
}
