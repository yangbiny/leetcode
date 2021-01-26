package com.impassive.alg.dp.repeat;

/** @author impassivey */
public class L494 {

  public static void main(String[] args) {
    int[] nums = {1, 1, 1, 1, 1};
    Solution solution = new Solution();
    System.out.println(solution.findTargetSumWays(nums, 3));
  }

  static class Solution implements Cloneable {
    public int findTargetSumWays(int[] nums, int target) {
      int sum = 0;
      for (int num : nums) {
        sum += num;
      }
      if (sum < target || (sum + target) % 2 == 1) {
        return 0;
      }
      int tmp = (target + sum) / 2;
      int[] dp = new int[tmp + 1];
      dp[0] = 1;
      for (int num : nums) {
        for (int i = tmp; i >= num; i--) {
          dp[i] = dp[i - num] + dp[i];
        }
      }
      return dp[tmp];
    }
  }
}
