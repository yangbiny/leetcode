package com.impassive.dp;

/** @author impassivey */
public class L198 {

  public static void main(String[] args) {
    int[] nums = {2, 1, 1, 2};
    int rob = new Solution().rob(nums);
    System.out.println(rob);
  }

  static class Solution {
    public int rob(int[] nums) {
      if (nums.length <= 2) {
        if (nums.length == 2) {
          return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 1) {
          return nums[0];
        }
        return 0;
      }
      int[] dp = new int[nums.length];
      dp[0] = nums[0];
      dp[1] = Math.max(nums[0], nums[1]);
      for (int i = 2; i < nums.length; i++) {
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
      }
      return dp[nums.length - 1];
    }

    public int rob2(int[] nums) {
      int pre2 = 0;
      int pre1 = 0;
      for (int i = 0; i < nums.length; i++) {
        int cur = Math.max(pre1, pre2 + nums[i]);
        pre2 = pre1;
        pre1 = cur;
      }
      return pre1;
    }
  }
}
