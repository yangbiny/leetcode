package com.impassive.alg.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author impassivey
 */
public class Bubbling {

  public static void main(String[] args) {
    int[] nums = {2, 1};
    sort(nums);
    System.out.println(Arrays.toString(nums));
  }

  private static void sort(int[] nums) {
    if (nums.length == 0 || nums.length == 1) {
      return;
    }
    int n = nums.length;
    boolean update = true;
    for (int i = 0; i < n && update; i++) {
      update = false;
      for (int j = i; j < n; j++) {
        if (nums[i] < nums[j]) {
          continue;
        }
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
        update = true;
      }
    }
  }
}
