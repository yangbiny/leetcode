package com.impassive.alg.dp.repeat;

/** @author impassivey */
public class L413 {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    System.out.println(new Solution().numberOfArithmeticSlices(nums));
  }

  static class Solution {
    public int numberOfArithmeticSlices(int[] A) {
      if (A.length < 3) {
        return 0;
      }
      int[] dp = new int[A.length + 1];
      dp[0] = 0;
      dp[1] = 0;
      int res = 0;
      for (int i = 2; i < A.length; i++) {
        if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
          dp[i] = dp[i - 1] + 1;
          res += dp[i];
        }
      }
      return res;
    }
  }
}
