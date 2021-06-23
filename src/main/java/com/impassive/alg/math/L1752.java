package com.impassive.alg.math;

/** @author impassivey */
public class L1752 {

  public static void main(String[] args) {
    int[] nums = { 3, 4, 5,2,1};
    System.out.println(new Solution().check(nums));
  }

  static class Solution {
    public boolean check(int[] nums) {
      boolean check = nums[0] >= nums[nums.length - 1];
      for (int i = 1; i < nums.length; i++) {
        if (nums[i] < nums[i - 1]){
          if (check){
            check = false;
          }else {
            return false;
          }
        }
      }
      return true;
    }
  }
}
