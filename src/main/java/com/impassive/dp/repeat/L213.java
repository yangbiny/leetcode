package com.impassive.dp.repeat;

/** @author impassivey */
public class L213 {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 1};
    System.out.println(new Solution().rob(nums));
  }

  static class Solution {
    public int rob(int[] nums) {
      if (nums.length == 0) {
        return 0;
      }
      if (nums.length < 2) {
        return nums[0];
      }
      if (nums.length == 2) {
        return Math.max(nums[0], nums[1]);
      }
      return Math.max(rot(nums, 0, nums.length - 1), rot(nums, 1, nums.length));
    }

    private int rot(int[] nums, int start, int end) {
      int n = nums.length;
      int[] dp = new int[n + 1];
      dp[start] = nums[start];
      dp[start + 1] = Math.max(nums[start], nums[start + 1]);
      for (int i = start + 2; i < end; i++) {
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
      }
      return dp[end - 1];
    }
  }
}
