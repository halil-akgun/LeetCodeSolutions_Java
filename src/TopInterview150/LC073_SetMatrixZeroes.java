package TopInterview150;

import java.util.Arrays;

/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

Example 1:
image: https://assets.leetcode.com/uploads/2020/08/17/mat1.jpg
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2:
image: https://assets.leetcode.com/uploads/2020/08/17/mat2.jpg
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 */
public class LC073_SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        setZeroes(matrix1);
        Arrays.stream(matrix1).forEach(t -> System.out.println(Arrays.toString(t)));

        int[][] matrix2 = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        setZeroes(matrix2);
        Arrays.stream(matrix2).forEach(t -> System.out.println(Arrays.toString(t)));
    }

    public static void setZeroes(int[][] matrix) {
        int[][] matrixCopy = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) matrixCopy[i] = matrix[i].clone();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrixCopy[i][j] == 0)
                    markZeroes(matrix, i, j);
            }
        }
    }

    private static void markZeroes(int[][] matrix, int i, int j) {
        for (int k = j+1; k < matrix[0].length; k++) {
            matrix[i][k] = 0;
        }
        for (int k = i+1; k < matrix.length; k++) {
            matrix[k][j] = 0;
        }
        for (int k = j-1; k >= 0; k--) {
            matrix[i][k] = 0;
        }
        for (int k = i-1; k >= 0; k--) {
            matrix[k][j] = 0;
        }
    }
}
