package com.impassive.dp;

/** @author impassivey */
public class L91 {

  public static void main(String[] args) {
    int result = new Solution().numDecodings("2101");
    System.out.println(result);
  }

  static class Solution {
    public int numDecodings(String s) {
      if (s == null || s.length() == 0) {
        return 0;
      }
      int n = s.length();
      int[] dp = new int[n + 1];
      dp[0] = 1;
      dp[1] = s.charAt(0) == '0' ? 0 : 1;
      for (int i = 2; i <= n; i++) {
        int one = Integer.parseInt(s.substring(i - 1, i));
        if (one != 0) {
          dp[i] += dp[i - 1];
        }
        if (s.charAt(i - 2) == '0') {
          continue;
        }
        int two = Integer.parseInt(s.substring(i - 2, i));
        if (two <= 26) {
          dp[i] += dp[i - 2];
        }
      }
      return dp[n];
    }
  }
}
