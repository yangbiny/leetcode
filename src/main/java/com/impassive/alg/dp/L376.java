package com.impassive.alg.dp;

/** @author impassivey */
public class L376 {

  public static void main(String[] args) {
    int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
    int result = new Solution().wiggleMaxLength(nums);
    System.out.println(result);
  }

  static class Solution {
    public int wiggleMaxLength(int[] nums) {
      int down = 1, up = 1;
      for (int i = 1; i < nums.length; i++) {
        // 到这个位置，可以删除持续上升的，然后计算有多少个
        if (nums[i] > nums[i - 1]) {
          up = down + 1;
        }
        // 删除持续下降的，然后在上一步的up上加1即可
        if (nums[i] < nums[i - 1]) {
          down = up + 1;
        }
      }
      return Math.max(down, up);
    }
  }
}
