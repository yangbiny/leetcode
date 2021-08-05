package com.impassive.alg.search;

public class L35 {

  public static void main(String[] args) {
    int[] nums = {3, 5, 7, 9, 10};
    System.out.println(new Solution().searchInsert(nums, 8));
  }

  static class Solution {
    public int searchInsert(int[] nums, int target) {
      if (nums.length == 0) {
        return 0;
      }
      int min = 0, max = nums.length - 1;
      while (min <= max) {
        if (min == max) {
          return nums[max] < target ? max + 1 : max;
        }
        int mid = (max - min) / 2 + min;
        if (nums[mid] == target) {
          return mid;
        } else if (nums[mid] > target) {
          max = mid - 1;
        } else {
          min = mid + 1;
        }
      }
      return min;
    }
  }
}
