package com.impassive.dp;

import java.util.ArrayList;
import java.util.List;

/** @author impassivey */
public class L279 {

  public static void main(String[] args) {
    int result = new Solution().numSquares(14);
    System.out.println(result);
  }

  static class Solution {

    /**
     * 使用动态规划的方式，递推公式为： dp[i] = Math.min(dp[i], d[i - sq] + 1) 解释：dp[i] 表示第i个数据可以拆分为最少 dp[i]个平方数的和。
     *
     * <p>sq的值是预先计算的到n为止的所有平方数。例如 17 生成的平方数为1，4，9，16
     *
     * <p>dp[i] = Math.min(dp[i], d[i - sq] + 1) 表示dp[i]的值可以选择当前dp[i]和dp[i - sq] + 1的最小值。 dp[i -
     * sq]表示i减去一个平方数后的结果，+ 1是需要加上减去的平方数
     *
     * @param n 需要解析的数据
     * @return 解析值
     */
    public int numSquares(int n) {
      if (n < 4) {
        return n;
      }
      List<Integer> squareList = generateSquareN(n);
      int[] dp = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        int min = Integer.MAX_VALUE;
        for (Integer sq : squareList) {
          if (i < sq) {
            break;
          }
          min = Math.min(min, dp[i - sq] + 1);
        }
        dp[i] = min;
      }
      return dp[n];
    }

    private List<Integer> generateSquareN(int n) {
      List<Integer> result = new ArrayList<>();
      int temp = 1, diff = 1;
      while (temp <= n) {
        result.add(temp);
        diff += 2;
        temp += diff;
      }
      return result;
    }
  }
}
