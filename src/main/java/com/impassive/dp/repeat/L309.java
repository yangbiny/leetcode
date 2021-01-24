package com.impassive.dp.repeat;

/** @author impassivey */
public class L309 {

  public static void main(String[] args) {
    int[] prices = {1, 2, 3, 0, 1};
    System.out.println(new Solution().maxProfit(prices));
  }

  static class Solution {
    public int maxProfit(int[] prices) {
      if (prices.length < 2) {
        return 0;
      }
      int n = prices.length;
      int[] hold = new int[n + 1];
      int[] noStock = new int[n + 1];
      hold[0] = -prices[0];
      hold[1] = Math.max(-prices[0], -prices[1]);
      noStock[1] = Math.max(hold[0] + prices[1], 0);
      for (int i = 2; i < n; i++) {
        // 表示第i天持有股票的金额
        hold[i] = Math.max(hold[i - 1], noStock[i - 2] - prices[i]);
        //  表示第i天不持有股票的金额
        noStock[i] = Math.max(hold[i - 1] + prices[i], noStock[i - 1]);
      }
      return Math.max(hold[n - 1], noStock[n - 1]);
    }
  }
}
