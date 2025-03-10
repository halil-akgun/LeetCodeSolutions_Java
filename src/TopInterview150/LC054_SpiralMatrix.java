package TopInterview150;

import java.util.List;

/*
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
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

    }
}
