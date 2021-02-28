package com.impassive.alg.dp.repeat;

/** @author impassivey */
public class L53 {

  public static void main(String[] args) {
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(new Solution().maxSubArray(nums));
  }

  static class Solution {
    public int maxSubArray(int[] nums) {
      if (nums.length == 0) {
        return 0;
      }
      int max = nums[0];
      int prev = max;
      for (int num : nums) {
        prev = prev > 0 ? prev + num : num;
        max = Math.max(prev, max);
      }
      return max;
    }
  }
}
