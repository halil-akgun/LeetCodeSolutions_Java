package TopInterview150;

import java.util.Arrays;

/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.

Example 1:
image: https://assets.leetcode.com/uploads/2020/08/28/mat1.jpg
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:
image: https://assets.leetcode.com/uploads/2020/08/28/mat2.jpg
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 */
public class LC048_RotateImage {
    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix1);
        System.out.println(Arrays.deepToString(matrix1));

        int[][] matrix2 = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        rotate(matrix2);
        System.out.println(Arrays.deepToString(matrix2));
    }

    public static void rotate(int[][] matrix) {
        // way 1
//        int a = matrix.length / 2, border = 0, b = matrix.length - 1 - border, temp;
//        while (a-- > 0) {
//            for (int tour = 0; tour < b; tour++) {
//                temp = matrix[border][matrix.length - 1 - border];
//                for (int i = matrix.length - border - 2; i >= border; i--) {
//                    matrix[border][i + 1] = matrix[border][i];
//                }
//                for (int i = border + 1; i < matrix.length - border; i++) {
//                    matrix[i - 1][border] = matrix[i][border];
//                }
//                for (int i = border + 1; i < matrix.length - border; i++) {
//                    matrix[matrix.length - 1 - border][i - 1] = matrix[matrix.length - 1 - border][i];
//                }
//                for (int i = matrix.length - border - 2; i >= border; i--) {
//                    matrix[i + 1][matrix.length - 1 - border] = matrix[i][matrix.length - 1 - border];
//                }
//                matrix[border + 1][matrix.length - 1 - border] = temp;
//            }
//            b -= 2;
//            border++;
//        }

        // way 2 (faster)
        // 1. Transpose the matrix (convert rows to columns)
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2. Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}
