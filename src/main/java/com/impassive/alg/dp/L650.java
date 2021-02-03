package com.impassive.alg.dp;

/** @author impassivey */
public class L650 {

  public static void main(String[] args) {
    System.out.println(new Solution().minSteps(50));
  }

  static class Solution {
    public int minSteps(int n) {
      int[] dp = new int[n + 1];
      int h = (int) Math.sqrt(n);
      for (int i = 2; i <= n; i++) {
        dp[i] = i;
        for (int j = 2; j <= h; j++) {
          if (i % j == 0) {
            dp[i] = Math.min(dp[j] + (i / j), dp[i / j] + j);
          }
        }
      }
      return dp[n];
    }
  }
}
