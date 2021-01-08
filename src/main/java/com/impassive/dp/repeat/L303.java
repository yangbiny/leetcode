package com.impassive.dp.repeat;

/** @author impassivey */
public class L303 {

  public static void main(String[] args) {
    int[] nums = {-2, 0, 3, -5, 2, -1};
    NumArray numArray = new NumArray(nums);
    System.out.println(numArray.sumRange(0, 2));
    System.out.println(numArray.sumRange(2, 5));
    System.out.println(numArray.sumRange(0, 5));
  }

  static class NumArray {

    private int[] nums;

    public NumArray(int[] nums) {
      this.nums = new int[nums.length + 1];
      for (int i = 0; i < nums.length; i++) {
        for (int j = i; j < nums.length; j++) {
          if (i == 0) {
            this.nums[i + 1] = nums[i];
            continue;
          }
          this.nums[i + 1] = this.nums[i] + nums[i];
        }
      }
    }

    public int sumRange(int start, int end) {
      if (nums.length == 0) {
        return 0;
      }
      return nums[end + 1] - nums[start];
    }
  }
}
