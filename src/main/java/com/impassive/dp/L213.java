package com.impassive.dp;

/** @author impassivey */
public class L213 {

  public static void main(String[] args) {
    int[] nums = {2, 3, 2};
    int rob = new Solution().rob(nums);
    System.out.println(rob);
  }

  static class Solution {
    public int rob(int[] nums) {
      if (nums.length <= 2) {
        if (nums.length == 2) {
          return Math.max(nums[0], nums[1]);
        }
        if(nums.length == 1){
          return nums[0];
        }
        return 0;
      }
      int n = nums.length;
      return Math.max(robR(nums, 0, n - 2), robR(nums, 1, n - 1));
    }

    private int robR(int[] nums, int start, int end) {
      int per2 = 0, per1 = 0;
      for (int i = start; i <= end; i++) {
        int cur = Math.max(per1, per2 + nums[i]);
        per2 = per1;
        per1 = cur;
      }
      return per1;
    }
  }
}
