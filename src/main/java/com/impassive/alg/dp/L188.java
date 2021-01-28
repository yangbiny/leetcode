package com.impassive.alg.dp;

/** @author impassivey */
public class L188 {

  public static void main(String[] args) {
    int[] prices = {3, 2, 6, 5, 0, 3};
    //int[] prices = {7, 6, 5, 4, 3, 2, 1};
    System.out.println(new Solution().maxProfit(3, prices));
  }

  static class Solution {
    public int maxProfit(int k, int[] prices) {
      if (prices.length == 0){
        return 0;
      }
      int n = prices.length;
      int[][][] dp = new int[n][2][k + 1];
      for (int i = k; i >= 1; i--) {
        dp[0][0][i] = 0;
        // 第0天的时候，无论买几次，都会是-prices[p]
        dp[0][1][i] = -prices[0];
      }
      for (int i = 1; i < n; i++) {
        for (int j = 1; j <= k; j++) {
          // 卖掉或者不买
          dp[i][0][j] = Math.max(dp[i - 1][1][j] + prices[i], dp[i - 1][0][j]);
          // 买或者不卖,买一次就消耗一次买的次数，所以需要j-1
          dp[i][1][j] = Math.max(dp[i - 1][0][j - 1] - prices[i], dp[i - 1][1][j]);
        }
      }
      int result = dp[n - 1][0][0];
      for (int i : dp[n - 1][0]) {
        if (i > result) {
          result = i;
        }
      }
      return result;
    }
  }
}
