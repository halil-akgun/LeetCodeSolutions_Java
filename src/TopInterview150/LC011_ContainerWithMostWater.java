package TopInterview150;

/*
You are given an integer array height of length n. There are n vertical lines drawn such that
the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Example 1:
image: https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1
 */
public class LC011_ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
        System.out.println(maxArea(new int[]{1, 1})); // 1
    }

    public static int maxArea(int[] height) {
        // way 1
//        int maxHeight = 0;
//        int maxWater = 0;
//        for (int i = 0; i < height.length - 1; i++) {
//            if (height[i] > maxHeight)
//                maxHeight = height[i];
//            else
//                continue;
//            for (int j = i + 1; j < height.length; j++) {
//                int min = Math.min(height[i], height[j]);
//                maxWater = Math.max(maxWater, min * (j - i));
//            }
//        }
//
//        return maxWater;

        // way 2
        int left = 0;
        int right = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            max = Math.max(max, minHeight * (right - left));

            while (left < right && height[left] <= minHeight)
                left++;

            while (right > left && height[right] <= minHeight)
                right--;
        }

        return max;
    }
}
