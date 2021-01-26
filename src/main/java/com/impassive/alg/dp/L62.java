package com.impassive.alg.dp;

/** @author impassivey */
public class L62 {

  public static void main(String[] args) {
    int result = new Solution().uniquePaths(3, 7);
    System.out.println(result);
  }

  static class Solution {
    public int uniquePaths(int m, int n) {
      if (m == 0 || n == 0) {
        return 0;
      }
      int[][] dp = new int[m][n];
      dp[0][0] = 1;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (j == 0) {
            if (i == 0) {
              continue;
            }
            dp[i][j] = dp[i - 1][j];
          } else if (i == 0) {
            dp[i][j] = dp[i][j - 1];
          } else {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
          }
        }
      }
      return dp[m - 1][n - 1];
    }
  }
}
