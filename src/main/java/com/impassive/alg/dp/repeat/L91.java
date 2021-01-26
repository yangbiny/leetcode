package com.impassive.alg.dp.repeat;

/** @author impassivey */
public class L91 {

  public static void main(String[] args) {
    System.out.println(new Solution().numDecodings("226"));
  }

  static class Solution {
    public int numDecodings(String s) {
      int n = s.length();
      int[] dp = new int[n + 1];
      dp[0] = 1;
      dp[1] = s.charAt(0) == '0' ? 0 : 1;
      for (int i = 2; i <= n; i++) {
        String tmp = s.substring(i - 1, i);
        if (Integer.parseInt(tmp) != 0) {
          dp[i] += dp[i - 1];
        }
        if (s.charAt(i - 2) == '0') {
          continue;
        }
        int sub = Integer.parseInt(s.substring(i - 2, i));
        if (sub <= 26) {
          dp[i] += dp[i - 2];
        }
      }
      return dp[n];
    }
  }
}
