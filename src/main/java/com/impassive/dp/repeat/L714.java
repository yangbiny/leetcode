package com.impassive.dp.repeat;

/** @author impassivey */
public class L714 {

  public static void main(String[] args) {
    int[] prices = {1, 3, 2, 8, 4, 9};
    System.out.println(new Solution().maxProfit(prices, 2));
  }

  static class Solution {
    public int maxProfit(int[] prices, int fee) {
      if (prices.length < 2) {
        return 0;
      }
      int n = prices.length;
      int[] hold = new int[n];
      int[] noStock = new int[n];
      hold[0] = -prices[0];
      noStock[1] = Math.max(hold[0] + prices[1] - fee, 0);
      for (int i = 1; i < n; i++) {
        hold[i] = Math.max(hold[i - 1], noStock[i - 1] - prices[i]);
        noStock[i] = Math.max(hold[i - 1] + prices[i] - fee, noStock[i - 1]);
      }
      return Math.max(hold[n - 1], noStock[n - 1]);
    }
  }
}
