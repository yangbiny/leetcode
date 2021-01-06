package com.impassive.dp.repeat;

/** @author impassivey */
public class L70 {

  public static void main(String[] args) {
    int climbStairs = new Solution().climbStairs(3);
    System.out.println(climbStairs);
  }

  static class Solution {
    public int climbStairs(int n) {
      if (n <= 2) {
        return n;
      }
      int[] dp = new int[n + 1];
      dp[1] = 1;
      dp[2] = 2;
      for (int i = 3; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
      }
      return dp[n];
    }
  }
}
