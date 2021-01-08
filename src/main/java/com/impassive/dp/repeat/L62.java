package com.impassive.dp.repeat;

/** @author impassivey */
public class L62 {

  public static void main(String[] args) {
    System.out.println(new Solution().uniquePaths(3, 7));
  }

  static class Solution {
    public int uniquePaths(int m, int n) {
      if(m == 0 || n == 0){
        return 0;
      }
      int[] dp = new int[n + 1];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (i == 0 && j == 0) {
            dp[0] = 1;
          } else if (i == 0) {
            dp[j] = dp[j - 1];
          } else if (j == 0) {
            dp[j] = dp[j];
          } else {
            dp[j] = dp[j] + dp[j - 1];
          }
        }
      }
      return dp[n - 1];
    }
  }
}
