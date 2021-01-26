package com.impassive.alg.dp.repeat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** @author impassivey */
public class L279 {

  public static void main(String[] args) {
    System.out.println(new Solution().numSquares(12));
  }

  static class Solution {
    public int numSquares(int n) {
      List<Integer> generate = generate(n);
      int[] dp = new int[n + 1];
      Arrays.fill(dp, n);
      for (int i = 1; i <= n; i++) {
        for (Integer integer : generate) {
          if (i == integer) {
            dp[i] = 1;
            continue;
          }
          if (integer > i) {
            continue;
          }
          dp[i] = Math.min(dp[i], dp[i - integer] + 1);
        }
      }
      return dp[n];
    }

    private List<Integer> generate(int n) {
      List<Integer> result = new ArrayList<>();

      int min = 1;
      int diff = 3;
      while (min <= n) {
        result.add(min);
        min += diff;
        diff += 2;
      }
      return result;
    }
  }
}
