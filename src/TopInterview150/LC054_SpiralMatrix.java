package TopInterview150;

import java.util.ArrayList;
import java.util.List;

/*
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
image: https://assets.leetcode.com/uploads/2020/11/13/spiral1.jpg
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
image: https://assets.leetcode.com/uploads/2020/11/13/spiral.jpg
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class LC054_SpiralMatrix {
    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        })); // [1,2,3,6,9,8,7,4,5]
        System.out.println(spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        })); // [1,2,3,4,8,12,11,10,9,5,6,7]
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
