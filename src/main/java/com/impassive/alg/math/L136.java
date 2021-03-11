package com.impassive.alg.math;

/** @author impassivey */
public class L136 {

  public static void main(String[] args) {
    int[] nums = {2, 2, 1};
    System.out.println(new Solution().singleNumber(nums));
  }

  static class Solution {
    public int singleNumber(int[] nums) {
      int single = 0;
      for (int num : nums) {
        single ^= num;
      }
      return single;
    }
  }
}
