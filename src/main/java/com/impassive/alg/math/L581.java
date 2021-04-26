package com.impassive.alg.math;

/** @author impassivey */
public class L581 {

  public static void main(String[] args) {
    int[] nums = {1,2,3,3,3};
    System.out.println(new Solution().findUnsortedSubarray(nums));
  }

  static class Solution {
    public int findUnsortedSubarray(int[] nums) {

      int n = nums.length;
      int start = 0;
      int end = n - 1;
      // 找到第一个递减的位置
      while (start + 1 < end && nums[start] <= nums[start + 1]) {
        start++;
      }
      // 最后一个递减的位置
      while (end - 1 >= start && nums[end] >= nums[end - 1]) {
        end--;
      }
      if (start == end) {
        return 0;
      }
      int min = nums[start];
      int max = nums[start];
      int result = end - start;
      int tempStart = start;
      // 找到两个范围中的最大值和最小值
      while (start <= end) {
        if (nums[start] < min) {
          min = nums[start];
        }
        if (nums[start] > max) {
          max = nums[start];
        }
        start++;
      }
      // 如果左边的比最小值大，说明还要继续包括
      while (tempStart >= 0) {
        if (nums[tempStart] > min) {
          result++;
        } else {
          break;
        }
        tempStart--;
      }
      // 加1 是为了比较在范围外的数字和范围内的数字进行比较
      end = end + 1;
      // 如果右边的比最大值小，还要继续包括
      while (end < n) {
        if (nums[end] < max) {
          result++;
        } else {
          break;
        }
        end++;
      }

      return result;
    }
  }
}
