package com.impassive.alg.sort;

import java.util.Arrays;
import java.util.Map.Entry;

/** @author impassivey */
public class Quick {

  public static void main(String[] args) {
    int[] nums = {4, 2, 5, 6, 7, 4, 5, 7, 5, 43, 5, 4, 54, 5, 21, 0};
    quickShort(nums, 0, nums.length - 1);
    System.out.println(Arrays.toString(nums));
  }

  private static void quickShort(int[] nums, int begin, int end) {
    if (begin >= end) {
      return;
    }
    int i = begin;
    int j = end;
    int key = nums[i];
    while (i < j) {
      while (i < j && nums[j] >= key) {
        j--;
      }
      if (i < j) {
        nums[i] = nums[j];
        i++;
      }
      while (i < j && nums[i] <= key) {
        i++;
      }
      if (i < j) {
        nums[j] = nums[i];
        j--;
      }
    }
    nums[i] = key;
    quickShort(nums, begin, i - 1);
    quickShort(nums, i + 1, end);
  }
}
