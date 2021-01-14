package com.impassive.dp.repeat;

/** @author impassivey */
public class L300 {

  public static void main(String[] args) {
    int[] nums = {0, 1, 0, 3, 2, 3};
    System.out.println(new Solution().lengthOfLIS(nums));
  }

  static class Solution {
    public int lengthOfLIS(int[] nums) {
      int[] dp = new int[nums.length];
      int ret = 0;
      for (int i = 0; i < nums.length; i++) {
        int max = 1;
        for (int j = 0; j < i; j++) {
          if (nums[j] >= nums[i]) {
            continue;
          }
          max = Math.max(max, dp[j] + 1);
        }
        dp[i] = max;
        if (ret < max) {
          ret = max;
        }
      }
      return ret;
    }
  }
}
