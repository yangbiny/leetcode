package com.impassive.dp.repeat;

/** @author impassivey */
public class L64 {

  public static void main(String[] args) {
    int[][] grid = {};
    System.out.println(new Solution().minPathSum(grid));
  }

  static class Solution {
    public int minPathSum(int[][] grid) {
      if (grid.length == 0 || grid[0].length == 0) {
        return 0;
      }
      int m = grid.length;
      int n = grid[0].length;
      int[][] dp = new int[m + 1][n + 1];
      dp[0][0] = grid[0][0];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (i == 0 && j == 0) {
            continue;
          }
          if (i == 0) {
            dp[i][j] = dp[i][j - 1] + grid[i][j];
          } else if (j == 0) {
            dp[i][j] = dp[i - 1][j] + grid[i][j];
          } else {
            dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
          }
        }
      }
      return dp[m - 1][n - 1];
    }
  }
}
