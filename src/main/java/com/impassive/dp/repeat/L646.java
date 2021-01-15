package com.impassive.dp.repeat;

import java.util.Arrays;
import java.util.Comparator;

/** @author impassivey */
public class L646 {

  public static void main(String[] args) {
    int[][] pairs = {{1,2},{2,3},{3,4}};
    System.out.println(new Solution().findLongestChain(pairs));
  }

  static class Solution {
    public int findLongestChain(int[][] pairs) {
      if (pairs.length == 0){
        return 0;
      }
      if (pairs[0].length == 0){
        return 1;
      }
      Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
      int[] dp = new int[pairs.length];
      Arrays.fill(dp, 1);
      dp[0] = 1;
      int ret = 0;
      for (int i = 0; i < pairs.length; i++) {
        for (int j = 0; j < i; j++) {
          if (pairs[i][0] > pairs[j][1]) {
            dp[i] = Math.max(dp[i], dp[j] + 1);
          }
          if (ret < dp[i]) {
            ret = dp[i];
          }
        }
      }
      return ret;
    }
  }
}
