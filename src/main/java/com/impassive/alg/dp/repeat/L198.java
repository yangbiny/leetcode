package com.impassive.alg.dp.repeat;

/** @author impassivey */
public class L198 {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 1};
    int rob = new Solution().rob(nums);
    System.out.println(rob);
  }

  static class Solution {
    public int rob(int[] nums) {
      if (nums.length == 0) {
        return 0;
      }
      int n = nums.length;
      if (n < 2) {
        return nums[0];
      }
      int[] dp = new int[n + 1];
      dp[0] = nums[0];
      dp[1] = Math.max(nums[1], nums[0]);
      for (int i = 2; i < n; i++) {
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
      }
      return dp[n - 1];
    }
  }
}
