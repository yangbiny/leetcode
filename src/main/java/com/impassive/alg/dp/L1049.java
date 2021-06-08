package com.impassive.alg.dp;

/** @author impassivey */
public class L1049 {

  public static void main(String[] args) {
    int[] nums = {31, 26, 33, 21, 40};
    System.out.println(new Solution().lastStoneWeightII(nums));
  }

  static class Solution {
    public int lastStoneWeightII(int[] stones) {
      int length = stones.length;
      if (length == 1) {
        return stones[0];
      }
      int sum = 0;
      int min = stones[0];
      for (int stone : stones) {
        sum += stone;
        if (stone < min){
          min = stone;
        }
      }
      int max = sum / 2;
      int[][] dp = new int[length + 1][max + 1];
      dp[0][0] = 0;
      for (int i = 1; i <= length; i++) {
        int stone = stones[i - 1];
        for (int j = 0; j <= max; j++) {
          if (j < min){
            continue;
          }
          dp[i][j] = dp[i - 1][j];
          if (j >= stone) {
            dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stone] + stone);
          }
        }
      }
      return Math.abs(sum - dp[length][max] * 2);
    }
  }
}
