package com.impassive.alg.dp;

/** @author impassivey */
public class L343 {

  public static void main(String[] args) {
    int result = new Solution().integerBreak(6);
    System.out.println(result);
  }

  static class Solution {
    public int integerBreak(int n) {
      // dp[i] 表示i划分后，乘积的最大值
      int[] dp = new int[n + 1];
      dp[1] = 1;
      for (int i = 2; i <= n; i++) {
        // 减1是因为0来乘肯定是最小的
        for (int j = 1; j <= i - 1; j++) {
          // i 拆分成 j 和 i - j ,找出不继续拆分 i - j 和 继续拆分 dp[i - j]的最大值
          dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
        }
      }
      return dp[n];
    }
  }
}
