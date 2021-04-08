package com.impassive.alg.math;

/** @author impassivey */
public class L4 {

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3};
    int[] nums2 = {2, 3, 4, 5, 6, 7};
    System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
  }

  static class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int n = nums1.length + nums2.length;
      final int mid = n / 2;
      if (n % 2 == 0) {
        return (getKthElement(nums1, nums2, mid) + getKthElement(nums1, nums2, mid + 1)) / 2.0;
      } else {
        return getKthElement(nums1, nums2, mid + 1);
      }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
      int length1 = nums1.length, length2 = nums2.length;
      int index1 = 0, index2 = 0;

      while (true) {
        // 边界情况
        if (index1 == length1) {
          return nums2[index2 + k - 1];
        }
        if (index2 == length2) {
          return nums1[index1 + k - 1];
        }
        if (k == 1) {
          return Math.min(nums1[index1], nums2[index2]);
        }

        // 正常情况
        int half = k / 2;
        // 每一个都是从第 k / 2个开始，因为第K个元素，不可能在 k / 2的前面
        int newIndex1 = Math.min(index1 + half, length1) - 1;
        int newIndex2 = Math.min(index2 + half, length2) - 1;
        int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
        // 如果 1 的比较小，则把 1 往后移动指针
        if (pivot1 <= pivot2) {
          // 计算目前还需要找到及格 k
          k -= (newIndex1 - index1 + 1);
          index1 = newIndex1 + 1;
        } else {
          // 否则移动 2 的指针
          k -= (newIndex2 - index2 + 1);
          index2 = newIndex2 + 1;
        }
      }
    }
  }
}
