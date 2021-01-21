package com.impassive.dp.repeat;

import java.util.Arrays;

/** @author impassivey */
public class L377 {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    System.out.println(new Solution().combinationSum4(nums, 4));
  }

  static class Solution {
    public int combinationSum4(int[] nums, int target) {
      int[] dp = new int[target + 1];
      Arrays.sort(nums);
      dp[0] = 1;
      for (int i = 1; i <= target;i++){
        for (int j = 0; j < nums.length && nums[j] <= i;j++){
          dp[i] += dp[i - nums[j]];
        }
      }
      return dp[target];
    }
  }
}
