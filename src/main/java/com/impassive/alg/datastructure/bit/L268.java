package com.impassive.alg.datastructure.bit;

/** @author impassivey */
public class L268 {

  public static void main(String[] args) {
    int[] arr = {1, 3, 0, 4};
    System.out.println(new Solution().missingNumber(arr));
  }

  static class Solution {
    public int missingNumber(int[] nums) {
      int n = nums.length;
      for (int i = 0; i < nums.length; i++) {
        n = n ^ nums[i] ^ i;
      }
      return n;
    }
  }
}
