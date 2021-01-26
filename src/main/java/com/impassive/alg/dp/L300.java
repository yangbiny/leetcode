package com.impassive.alg.dp;

/** @author impassivey */
public class L300 {

  public static void main(String[] args) {
    int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
    int result = new Solution().lengthOfLIS(nums);
    System.out.println(result);
  }

  static class Solution {
    public int lengthOfLIS(int[] nums) {
      if (nums.length == 0) {
        return 0;
      }
      int[] dp = new int[nums.length + 1];
      int ret = 0;
      for (int i = 0; i < nums.length; i++) {
        int max = 1;
        for (int j = 0; j < i; j++) {
          if (nums[i] <= nums[j]) {
            continue;
          }
          max = Math.max(max, dp[j] + 1);
        }
        dp[i] = max;
        if (max > ret){
          ret = max;
        }
      }
      return ret;
    }
  }
}
