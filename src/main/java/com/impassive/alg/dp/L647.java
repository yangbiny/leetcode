package com.impassive.alg.dp;

import java.util.Arrays;

/** @author impassivey */
public class L647 {

  public static void main(String[] args) {
    System.out.println(new Solution().countSubstrings("ababa"));
  }

  static class Solution {
    public int countSubstrings(String s) {
      int len = s.length();
      int[][] dp = new int[len + 1][len + 1];
      for (int i = 1; i <= len; i++) {
        for (int j = i; j <= len; j++) {
          if (i == j) {
            dp[i][j] = 1;
            continue;
          }
          if (s.charAt(i - 1) == s.charAt(j - 1)) {
            dp[i][j] = dp[i][j - 1] + check(s.substring(i - 1, j));
          } else {
            dp[i][j] = dp[i][j - 1];
          }
        }
      }
      int result = 0;
      for (int[] ints : dp) {
        result += ints[ints.length - 1];
      }
      return result;
    }

    private int check(String substring) {
      int len = substring.length();
      if (len == 0 || len == 1) {
        return len;
      }
      int result = 0;
      int start = 0;
      while (start < len) {
        if (substring.charAt(start) != substring.charAt(len - 1)) {
          return 0;
        }
        start++;
        len--;
      }
      return 1;
    }
  }
}
