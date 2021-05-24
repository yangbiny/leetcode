package com.impassive.alg.dp;

public class L664 {

    public static void main(String[] args) {
        System.out.println(new Solution().strangePrinter("abcaab"));
    }

    static class Solution {
        public int strangePrinter(String s) {
            if (s.length() <= 1) {
                return s.length();
            }
            int n = s.length();
            int[][] dp = new int[n][n];
            char[] chars = s.toCharArray();
            for (int i = n - 1; i >= 0; i--) {
                dp[i][i] = 1;
                for (int j = i + 1; j < n; j++) {
                    if (chars[i] == chars[j]) {
                        dp[i][j] = dp[i][j - 1];
                    } else {

                        int min = Integer.MAX_VALUE;
                        for (int k = i; k < j; k++) {
                            min = Math.min(min, dp[i][k] + dp[k + 1][j]);
                        }
                        dp[i][j] = min;
                    }
                }

            }

            return dp[0][n - 1];
        }
    }
}
