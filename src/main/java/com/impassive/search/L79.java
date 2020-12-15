package com.impassive.search;

/**
 * @see <a href="https://leetcode-cn.com/problems/word-search/">leetcode</a>
 * @author impassivey
 */
public class L79 {

  public static void main(String[] args) {
    char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    boolean exist = new Solution().exist(board, "ABCCED");
    System.out.println(exist);
  }

  static class Solution {

    private int m;
    private int n;

    private int[][] direct = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
      if (board.length == 0 || board[0].length == 0 || word.length() == 0) {
        return false;
      }
      m = board.length;
      n = board[0].length;
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          if (board[i][j] != word.charAt(0)) {
            continue;
          }
          boolean[][] marked = new boolean[m][n];
          if (dfs(board, word, 0, i, j, marked)) {
            return true;
          }
        }
      }
      return false;
    }

    private boolean dfs(char[][] board, String word, int len, int i, int j, boolean[][] marked) {
      if (word.length() == len) {
        return true;
      }
      if (i >= m || i < 0 || j >= n || j < 0 || marked[i][j] || board[i][j] != word.charAt(len)) {
        return false;
      }
      marked[i][j] = true;
      for (int[] item : direct) {
        if (dfs(board, word, len + 1, i + item[0], j + item[1], marked)) {
          return true;
        }
      }
      marked[i][j] = false;
      return false;
    }
  }
}
