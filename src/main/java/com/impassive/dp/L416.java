package com.impassive.dp;

/** @author impassivey */
public class L416 {

  public static void main(String[] args) {
    int[] nums = {1, 3};
    boolean result = new Solution().canPartition(nums);
    System.out.println(result);
  }

  static class Solution {

    /**
     * 1.先算出总和
     *
     * <p>2. 求出总和的一半
     *
     * <p>3. 从数组中找出能否组合成一半的值，存在即返回true
     *
     * <p>dp[j] 表示有没有到过j 这个数。一旦有值减为0， 即可到达
     *
     * @param nums 数组
     * @return true
     */
    public boolean canPartition(int[] nums) {
      if (nums.length == 0) {
        return true;
      }
      if (nums.length == 1) {
        return false;
      }
      int all = 0;
      for (int num : nums) {
        all += num;
      }
      if (all % 2 == 1) {
        return false;
      }
      int temp = all / 2;
      boolean[] dp = new boolean[temp + 1];
      dp[0] = true;
      for (int num : nums) {
        for (int j = temp; j >= num; j--) {
          dp[j] = dp[j] || dp[j - num];
        }
      }
      return dp[temp];
    }
  }
}
