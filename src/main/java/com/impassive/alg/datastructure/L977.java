package com.impassive.alg.datastructure;

import java.util.Arrays;

public class L977 {

  public static void main(String[] args) {
    int[] nums = {-7, -1, 2, 3, 11};
    System.out.println(Arrays.toString(new Solution().sortedSquares(nums)));
  }

  static class Solution {
    public int[] sortedSquares(int[] nums) {
      int length = nums.length;
      int[] newNums = new int[length];
      int right = 0, left = length - 1;
      int newRight = length - 1;
      while (right <= left) {
        int r = nums[right] * nums[right];
        int l = nums[left] * nums[left];
        if (r <= l) {
          newNums[newRight--] = l;
          left--;
        } else {
          newNums[newRight--] = r;
          right++;
        }
      }
      return newNums;
    }
  }
}
