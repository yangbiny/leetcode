package com.impassive.alg.dp;

/** @author impassivey */
public class L877 {

  public static void main(String[] args) {
    int[] piles = {5, 3, 4, 5, 6, 7, 8, 9, 10,12};
    System.out.println(new Solution().stoneGame(piles));
  }

  static class Solution {
    public boolean stoneGame(int[] piles) {
      if (piles.length == 2) {
        return true;
      }
      int len = piles.length;
      int[][] dp = new int[len][len];
      for (int i = 0; i < piles.length; i++) {
        dp[i][i] = piles[i];
        for (int j = i + 1; j < piles.length; j++) {
          dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
        }
      }
      return dp[0][len - 1] > 0;
    }
  }
}
