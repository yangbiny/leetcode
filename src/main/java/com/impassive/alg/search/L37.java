package com.impassive.alg.search;

/** @author impassivey */
public class L37 {

  public static void main(String[] args) {
    char[][] boards = {
      {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
      {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
      {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
      {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
      {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
      {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
      {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
      {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
      {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };
    new Solution().solveSudoku(boards);
  }

  static class Solution {

    // 行已使用的数字
    private boolean[][] usedRow = new boolean[10][10];
    // 列已使用的数字
    private boolean[][] usedCol = new boolean[10][10];
    // 小九宫格已使用的数字
    private boolean[][] usedSmall = new boolean[10][10];

    public void solveSudoku(char[][] board) {
      for (int i = 0; i < board.length; i++) {
        for (int i1 = 0; i1 < board[i].length; i1++) {
          if (board[i][i1] == '.') {
            continue;
          }
          int num = board[i][i1] - '0';
          usedRow[i][num] = true;
          usedCol[i1][num] = true;
          usedSmall[cellNum(i, i1)][num] = true;
        }
      }
      traceback(0, 0, board);
    }

    private boolean traceback(int row, int col, char[][] board) {
      while (row < 9 && board[row][col] != '.') {
        row = col == 8 ? row + 1 : row;
        col = col == 8 ? 0 : col + 1;
      }
      if (row == 9) {
        return true;
      }

      for (int i = 1; i <= 9; i++) {
        if (usedRow[row][i] || usedCol[col][i] || usedSmall[cellNum(row, col)][i]) {
          continue;
        }
        usedRow[row][i] = usedCol[col][i] = usedSmall[cellNum(row, col)][i] = true;
        board[row][col] = (char) (i + '0');
        if (traceback(row, col, board)) {
          return true;
        }
        board[row][col] = '.';
        usedRow[row][i] = usedCol[col][i] = usedSmall[cellNum(row, col)][i] = false;
      }
      return false;
    }

    private int cellNum(int row, int col) {
      int r = row / 3;
      int c = col / 3;
      return r * 3 + c;
    }
  }
}
