package com.impassive.alg.datastructure.bit;

/** @author impassivey */
public class L136 {

  public static void main(String[] args) {
    final Solution solution = new Solution();
    int[] arr = {1, 2, 1, 4, 2};
    System.out.println(solution.singleNumber(arr));
  }

  static class Solution {
    public int singleNumber(int[] nums) {
      int temp = 0;
      for (int num : nums) {
        temp = num ^ temp;
      }
      return temp;
    }
  }
}
