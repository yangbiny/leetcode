package com.impassive.dp;

import java.util.Arrays;
import java.util.Comparator;

/** @author impassivey */
public class L646 {

  public static void main(String[] args) {
    int[][] pairs = {{1, 2}, {3, 4}, {2, 3}};
    int result = new Solution().findLongestChain(pairs);
    System.out.println(result);
  }

  static class Solution {
    public int findLongestChain(int[][] pairs) {
      Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
      int[] dp = new int[pairs.length];
      Arrays.fill(dp, 1);
      int ret = 1;
      for (int i = 0; i < pairs.length; i++) {
        for (int j = 0; j < i; j++) {
          if (pairs[i][0] > pairs[j][1]) {
            dp[i] = Math.max(dp[i], dp[j] + 1);
            if (dp[i] > ret) {
              ret = dp[i];
            }
          }
        }
      }
      return ret;
    }
  }
}
