package com.impassive.dp.repeat;

/** @author impassivey */
public class L518 {

  public static void main(String[] args) {
    int[] coins = {1, 2, 5};
    System.out.println(new Solution().change(5, coins));
  }

  static class Solution {
    public int change(int amount, int[] coins) {
      if (amount == 0 || coins.length == 0) {
        return 1;
      }
      int[] dp = new int[amount + 1];
      dp[0] = 1;
      for (int coin : coins) {
        for (int i = coin;i <= amount;i++){
          dp[i] += dp[i - coin];
        }
      }
      return dp[amount];
    }
  }
}
