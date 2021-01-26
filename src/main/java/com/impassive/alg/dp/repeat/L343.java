package com.impassive.alg.dp.repeat;

/** @author impassivey */
public class L343 {

  public static void main(String[] args) {
    System.out.println(new Solution().integerBreak(10));
  }

  static class Solution {
    public int integerBreak(int n) {
      int[] dp = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j < i; j++) {
          dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
        }
      }
      return dp[n];
    }
  }
}
