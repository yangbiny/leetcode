package com.impassive.alg.dp.repeat;

/** @author impassivey */
public class L1143 {

  public static void main(String[] args) {
    System.out.println(new Solution().longestCommonSubsequence("abcd", "scde"));
  }

  static class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
      int m = text1.length();
      int n = text2.length();
      if (m == 0 || n == 0) {
        return 0;
      }

      int[][] dp = new int[m + 1][n + 1];
      for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= i && j <= n; j++) {
          if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
          } else {
            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
          }
        }
      }
      return dp[m][n];
    }
  }
}
