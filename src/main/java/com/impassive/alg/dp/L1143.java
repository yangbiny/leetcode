package com.impassive.alg.dp;

/** @author impassivey */
public class L1143 {

  public static void main(String[] args) {
    int result = new Solution().longestCommonSubsequence("bsbininm", "jmjkbkjkv");
    System.out.println(result);
  }

  static class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
      if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
        return 0;
      }
      int n1 = text1.length();
      int n2 = text2.length();
      int[][] dp = new int[n1 + 1][n2 + 1];
      for (int i = 1; i <= n1; i++) {
        for (int j = 1; j <= n2; j++) {
          if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
          } else {
            dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
          }
        }
      }
      return dp[n1][n2];
    }
  }
}
