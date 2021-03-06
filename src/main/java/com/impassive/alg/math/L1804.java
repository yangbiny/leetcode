package com.impassive.alg.math;

/** @author impassivey */
public class L1804 {

  public static void main(String[] args) {
    int[] check = {1, 2, 4, 2, 3, 1, 2, 4, 5, 1};
    System.out.println(new Solution().findRepeatNumberV2(check));
  }

  static class Solution {
    public int findRepeatNumber(int[] nums) {
      if (nums.length == 0 || nums.length == 1) {
        return 0;
      }
      int n = nums.length;
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i <= n; i++) {
        sb.append("0");
      }
      for (int num : nums) {
        if (sb.charAt(num) != '0') {
          return num;
        }
        sb.replace(num, num + 1, "1");
      }
      return 0;
    }

    public int findRepeatNumberV2(int[] nums) {
      int n = nums.length;
      for (int i = 0 ; i < n;i++){
        int k = nums[i];
        if (k < 0){
          k += n;
        }
        if (nums[k] < 0){
          return k;
        }
        nums[k] -= n;
      }
      return 0;
    }
  }
}
