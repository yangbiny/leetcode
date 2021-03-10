package com.impassive.alg.math;

import java.util.Arrays;

/** @author impassivey */
public class L283 {

  public static void main(String[] args) {
    int[] nums = {0, 1, 0, 3, 12};
    new Solution().moveZeroes(nums);
    System.out.println(Arrays.toString(nums));
  }

  static class Solution {
    public void moveZeroes(int[] nums) {
      int n = nums.length;
      int index = 0;
      for (int i = 0; i < n; i++) {
        if (nums[i] != 0) {
          nums[index] = nums[i];
          index++;
        }
      }
      int cnt = n - index;
      for (int i = 0; i < cnt; i++) {
        nums[index] = 0;
        index++;
      }
    }
  }
}
