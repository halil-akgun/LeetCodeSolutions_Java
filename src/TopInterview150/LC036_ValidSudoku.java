package TopInterview150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

 - Each row must contain the digits 1-9 without repetition.
 - Each column must contain the digits 1-9 without repetition.
 - Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Note:
 - A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 - Only the filled cells need to be validated according to the mentioned rules.

Example 1:
Input: board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true

Example 2:
Input: board =
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8.
Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 */
public class LC036_ValidSudoku {
    public static void main(String[] args) {
//        System.out.println(isValidSudoku(new char[][]{
//                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        })); // true
//        System.out.println(isValidSudoku(new char[][]{
//                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        })); // false
        System.out.println(isValidSudoku(new char[][]{
                {'.', '8', '7', '6', '5', '4', '3', '2', '1'},
                {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'9', '.', '.', '.', '.', '.', '.', '.', '.'}
        })); // true
    }

    public static boolean isValidSudoku(char[][] board) {
        Map<Integer, List<Integer>> row = new HashMap<>();
        Map<Integer, List<Integer>> col = new HashMap<>();
        Map<Integer, List<Integer>> box = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            row.put(i, new ArrayList<>());
            col.put(i, new ArrayList<>());
            box.put(i, new ArrayList<>());
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char chRow = board[i][j];
                char chCol = board[j][i];
                if (chRow != '.') {
                    if (!row.get(i).contains(chRow - '0')) {
                        row.get(i).add(chRow - '0');
                    } else {
                        return false;
                    }
                    int boxNum = (i / 3 * 3) + (j / 3);
                    if (!box.get(boxNum).contains(chRow - '0')) {
                        box.get(boxNum).add(chRow - '0');
                    } else {
                        return false;
                    }
                }
                if (chCol != '.') {
                    if (!col.get(j).contains(chCol - '0')) {
                        col.get(j).add(chCol - '0');
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
