package com.impassive.alg.dp;

/** @author impassivey */
public class L322 {

  public static void main(String[] args) {
    int[] coins = {1, 2, 5};
    int result = new Solution().coinChange(coins, 11);
    System.out.println(result);
  }

  static class Solution {
    public int coinChange(int[] coins, int amount) {
      if (coins.length == 0) {
        return -1;
      }
      int[] dp = new int[amount + 1];
      for (int coin : coins) {
        for (int i = coin; i <= amount; i++) {
          if (i == coin) {
            dp[coin] = 1;
          } else if (dp[i] == 0 && dp[i - coin] != 0) {
            dp[i] = dp[i - coin] + 1;
          } else if (dp[i - coin] != 0) {
            dp[i] = Math.min(dp[i], dp[i - coin] + 1);
          }
        }
      }
      return dp[amount] == 0 ? -1 : dp[amount];
    }
  }
}
