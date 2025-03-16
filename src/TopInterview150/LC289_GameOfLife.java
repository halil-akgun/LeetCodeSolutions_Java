package TopInterview150;

import java.util.Arrays;

/*
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton
devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state:
live (represented by a 1) or dead (represented by a 0). Each cell interacts with its
eight neighbors (horizontal, vertical, diagonal) using the following four rules
(taken from the above Wikipedia article):
 - Any live cell with fewer than two live neighbors dies as if caused by under-population.
 - Any live cell with two or three live neighbors lives on to the next generation.
 - Any live cell with more than three live neighbors dies, as if by over-population.
 - Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

The next state of the board is determined by applying the above rules simultaneously to every
cell in the current state of the m x n grid board. In this process, births and deaths occur simultaneously.

Given the current state of the board, update the board to reflect its next state.

Note that you do not need to return anything.

Example 1:
Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

Example 2:
Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]
 */
public class LC289_GameOfLife {
    public static void main(String[] args) {
        int[][] board1 = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(board1);
        Arrays.stream(board1).forEach(t -> System.out.println(Arrays.toString(t)));

        int[][] board2 = new int[][]{{1, 1}, {1, 0}};
        gameOfLife(board2);
        Arrays.stream(board2).forEach(t -> System.out.println(Arrays.toString(t)));
    }

    public static void gameOfLife(int[][] board) {
        int[][] boardCopy = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++)
            boardCopy[i] = board[i].clone();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int liveNeighbors = countLiveNeighbors(boardCopy, i, j);
                if (liveNeighbors < 2 || liveNeighbors > 3)
                    board[i][j] = 0;
                else if (liveNeighbors == 3)
                    board[i][j] = 1;
            }
        }
    }

    private static int countLiveNeighbors(int[][] board, int i, int j) {
        int liveNeighbors = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k == i && l == j)
                    continue;
                if (k < 0 || l < 0 || k >= board.length || l >= board[0].length)
                    continue;
                if (board[k][l] == 1)
                    liveNeighbors++;
            }
        }
        return liveNeighbors;
    }
}
