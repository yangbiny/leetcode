package com.impassive.alg.datastructure;

public class L283 {

  public static void main(String[] args) {
    int[] nums = {0, 1, 0, 3, 12};
    new Solution().moveZeroes(nums);
  }

  static class Solution {
    public void moveZeroes(int[] nums) {
      int begin = 0;
      int lastIndex = 0;
      int writeIndex = begin;
      while (begin < nums.length) {
        if (nums[begin] == 0) {
          lastIndex++;
          begin++;
          continue;
        }
        nums[writeIndex] = nums[begin];
        writeIndex++;
        begin++;
      }
      while (lastIndex > 0){
        nums[nums.length - lastIndex] = 0;
        lastIndex--;
      }
    }
  }
}
