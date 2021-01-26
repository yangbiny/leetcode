package com.impassive.alg.dp;

/** @author impassivey */
public class L474 {

  public static void main(String[] args) {
    String[] strs = {"10", "0001", "111001", "1", "0"};
    int maxForm = new Solution().findMaxForm(strs, 5, 3);
    System.out.println(maxForm);
  }

  static class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
      if (strs.length == 0) {
        return 0;
      }
      int[][] dp = new int[m + 1][n + 1];
      for (String str : strs) {
        int one = 0, zero = 0;
        for (char c : str.toCharArray()) {
          if (c == '0') {
            zero++;
          } else {
            one++;
          }
        }
        for (int i = m; i >= zero; i--) {
          for (int j = n; j >= one; j--) {
            dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
          }
        }
      }
      return dp[m][n];
    }
  }
}
