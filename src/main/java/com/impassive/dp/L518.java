package com.impassive.dp;

/** @author impassivey */
public class L518 {

  public static void main(String[] args) {
    int[] coins = {1, 2, 5};
    int change = new Solution().change(5, coins);
    System.out.println(change);
  }

  static class Solution {
    public int change(int amount, int[] coins) {
      int[] dp = new int[amount + 1];
      dp[0] = 1;
      for (int coin : coins) {
        for (int i = coin; i <= amount; i++) {
          dp[i] += dp[i - coin];
        }
      }
      return dp[amount];
    }
  }
}
