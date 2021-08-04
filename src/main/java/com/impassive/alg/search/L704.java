package com.impassive.alg.search;

public class L704 {

  public static void main(String[] args) {
    int[] nums = {-1, 0, 3, 5, 9, 12};
    System.out.println(new Solution().search(nums, 9));
  }

  static class Solution {
    public int search(int[] nums, int target) {
      if (nums.length == 0) {
        return -1;
      }
      int min = 0, max = nums.length - 1;
      while (min <= max) {
        if (min == max) {
          return nums[min] == target ? min : -1;
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
      return 0;
    }
  }
}
