package com.impassive.dp;

/** @author impassivey */
public class L64 {

  public static void main(String[] args) {
    int[][] grid = {{9, 1, 4, 8}};
    int result = new Solution().minPathSum2(grid);
    System.out.println(result);
  }

  static class Solution {
    // dp[i][j] = Math.min(dp[i][j - 1],dp[i - 1][j])
    public int minPathSum(int[][] grid) {
      if (grid.length == 0 || grid[0].length == 0) {
        return 0;
      }
      if (grid.length == 1 && grid[0].length == 1) {
        return grid[0][0];
      }
      int n = grid.length, m = grid[0].length;
      int[][] dp = new int[n][m];
      dp[0][0] = grid[0][0];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (i > 0 && j > 0) {
            dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
          }
          if (i > 0 && j == 0) {
            dp[i][j] = grid[i][j] + dp[i - 1][j];
          }
          if (j > 0 && i == 0) {
            dp[i][j] = grid[i][j] + dp[i][j - 1];
          }
        }
      }
      return dp[n - 1][m - 1];
    }

    public int minPathSum2(int[][] grid) {
      if (grid.length == 0 || grid[0].length == 0) {
        return 0;
      }
      int m = grid.length, n = grid[0].length;
      int[] dp = new int[n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (j == 0) {
            dp[j] = dp[j];
          } else if (i == 0) {
            dp[j] = dp[j - 1];
          } else {
            dp[j] = Math.min(dp[j], dp[j - 1]);
          }
          dp[j] += grid[i][j];
        }
      }
      return dp[n - 1];
    }
  }
}
