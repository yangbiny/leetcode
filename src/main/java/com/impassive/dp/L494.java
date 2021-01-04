package com.impassive.dp;

/** @author impassivey */
public class L494 {

  public static void main(String[] args) {
    int[] nums = {1, 1, 1, 1, 1};
    int targetSumWays = new Solution().findTargetSumWays(nums, 3);
    System.out.println(targetSumWays);
  }

  static class Solution {
    public int findTargetSumWays(int[] nums, int S) {
      int sum = 0;
      for (int num : nums) {
        sum += num;
      }
      // 如果总和小于 目标值 或者 sum + S 的值为奇数，则直接返回0
      if (sum < S || (sum + S) % 2 == 1) {
        return 0;
      }
      int temp = (sum + S) / 2;
      // dp[i]:和为i的计算方式的总数
      int[] dp = new int[temp + 1];
      dp[0] = 1;
      for (int num : nums) {
        for (int i = temp; i >= num; i--) {
          // 和为i的计算方式是在  当前的计算方式 + 减去num后，和为i的计算方式的总和
          dp[i] = dp[i] + dp[i - num];
        }
      }
      return dp[temp];
    }
  }
}
