package com.impassive.dp.repeat;

/** @author impassivey */
public class L376 {

  public static void main(String[] args) {
    int[] nums = {1, 7, 4, 9, 2, 5};
    System.out.println(new Solution().wiggleMaxLength(nums));
  }

  static class Solution {
    public int wiggleMaxLength(int[] nums) {
      if (nums.length == 0){
        return 0;
      }
      int up = 1;
      int down = 1;
      for (int i = 1; i < nums.length; i++) {
        if (nums[i] > nums[i - 1]){
          up = down + 1;
        }else if (nums[i] < nums[i - 1]){
          down = up + 1;
        }
      }
      return Math.max(up, down);
    }
  }
}
