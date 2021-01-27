package com.impassive.alg.dp;

/** @author impassivey */
public class L123 {

  public static void main(String[] args) {
    int[] prices = {7, 6, 5, 4, 3, 2};
    System.out.println(new Solution().maxProfit(prices));
  }

  static class Solution {
    public int maxProfit(int[] prices) {
      if (prices.length == 0) {
        return 0;
      }
      int sold1 = 0, sold2 = 0, hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
      for (int price : prices) {

        int h1Tmp = hold1;
        int s2Tmp = sold2;
        int s1Tmp = sold1;
        int h2Tmp = hold2;

        hold1 = Math.max(-price, hold1);
        sold1 = Math.max(h1Tmp + price, s1Tmp);
        hold2 = Math.max(s1Tmp - price, h2Tmp);
        sold2 = Math.max(h2Tmp + price, s2Tmp);
      }
      return Math.max(sold1, sold2);
    }
  }
}
