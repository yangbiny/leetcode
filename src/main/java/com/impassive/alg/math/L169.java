package com.impassive.alg.math;

/** @author impassivey */
public class L169 {

  public static void main(String[] args) {
    int[] nums = {1, 2, 4, 5, 6, 2, 2, 2, 2, 2};
    System.out.println(new Solution().majorityElement(nums));
  }

  static class Solution {
    public int majorityElement(int[] nums) {
      int can = 0, count = 0;
      for (int num : nums) {
        if (num != can) {
          if (count != 0) {
            count--;
            continue;
          }
          can = num;
        }
        count++;
      }
      return can;
    }
  }
}
