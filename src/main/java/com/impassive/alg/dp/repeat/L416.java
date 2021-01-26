package com.impassive.alg.dp.repeat;

/** @author impassivey */
public class L416 {

  public static void main(String[] args) {
    int[] nums = {1, 5, 5, 11};
    System.out.println(new Solution().canPartition(nums));
  }

  static class Solution {
    public boolean canPartition(int[] nums) {
      if (nums.length == 0) {
        return true;
      }
      if (nums.length == 1) {
        return false;
      }
      int sum = 0;
      for (int num : nums) {
        sum += num;
      }
      if (sum % 2 == 1) {
        return false;
      }
      int target = sum / 2;
      boolean[] dp = new boolean[target + 1];
      for (int num : nums) {
        if (num <= target) {
          dp[num] = true;
        }
        for (int j = target; j >= num; j--) {
          dp[j] = dp[j] || dp[j - num];
        }
      }
      return dp[target];
    }
  }
}
