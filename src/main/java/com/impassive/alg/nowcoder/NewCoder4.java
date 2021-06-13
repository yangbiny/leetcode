package com.impassive.alg.nowcoder;

import org.checkerframework.checker.units.qual.A;

/** @author impassivey */
public class NewCoder4 {

  public static void main(String[] args) {
    int[] nums = {2, 7, 9, 4};
    System.out.println(new MaxInnerRec().countArea(nums, 4));
  }

  public static class MaxInnerRec {
    public int countArea(int[] A, int n) {
      return findMax(A, 0, n - 1);
    }

    private int findMax(int[] nums, int begin, int end) {
      if (begin > end) {
        return 0;
      }
      if (begin == end) {
        return nums[end];
      }
      int min = findMin(nums, begin, end);
      int max = nums[min] * (end - begin + 1);
      max = Math.max(findMax(nums, begin, min - 1), max);
      max = Math.max(findMax(nums, min + 1, end), max);
      return max;
    }

    private int findMin(int[] a, int begin, int end) {
      int min = a[begin];
      int minIndex = begin;
      for (int i = begin; i <= end; i++) {
        if (a[i] < min) {
          min = a[i];
          minIndex = i;
        }
      }
      return minIndex;
    }
  }
}
