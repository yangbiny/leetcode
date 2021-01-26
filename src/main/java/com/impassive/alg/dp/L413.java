package com.impassive.alg.dp;

import java.util.Arrays;

/** @author impassivey */
public class L413 {

  public static void main(String[] args) {
    int[] num = {2, 3, 4, 5, 6, 7, 8};
    int result = new Solution().numberOfArithmeticSlices(num);
    System.out.println(result);
  }

  static class Solution {
    public int numberOfArithmeticSlices(int[] A) {
      if (A.length < 3) {
        return 0;
      }
      int[] dp = new int[A.length];
      Arrays.fill(dp, 0);
      for (int i = 2; i < A.length; i++) {
        if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
          dp[i] = dp[i - 1] + 1;
        }
      }
      int total = 0;
      for (int i : dp) {
        total += i;
      }
      return total;
    }
  }
}
