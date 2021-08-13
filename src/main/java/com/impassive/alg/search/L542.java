package com.impassive.alg.search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class L542 {

  public static void main(String[] args) {
    int[][] mat = {
      {1, 1, 0, 0, 1, 0, 0, 1, 1, 0},
      {1, 0, 0, 1, 0, 1, 1, 1, 1, 1},
      {1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
      {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
      {0, 0, 1, 1, 1, 1, 1, 1, 1, 0},
      {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
      {0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
      {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
      {0, 1, 0, 1, 1, 0, 1, 1, 1, 1},
      {1, 1, 1, 0, 1, 0, 1, 1, 1, 1}
    };
    System.out.println(Arrays.deepToString(new Solution().updateMatrix(mat)));
  }

  static class Solution {

    private final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] updateMatrix(int[][] mat) {
      int length = mat.length;
      int yLength = mat[0].length;
      int[][] dp = new int[length][yLength];
      for (int[] ints : dp) {
        Arrays.fill(ints, -1);
      }
      Queue<int[]> queue = new LinkedList<>();
      for (int i = 0; i < length; i++) {
        for (int j = 0; j < yLength; j++) {
          if (mat[i][j] == 0) {
            dp[i][j] = 0;
            queue.add(new int[] {i, j});
          }
        }
      }

      while (!queue.isEmpty()) {
        int[] poll = queue.poll();
        int x = poll[0], y = poll[1];

        for (int[] ints : direction) {
          int i = ints[0] + x;
          int j = ints[1] + y;
          if ((i < 0 || j < 0 || i >= length || j >= yLength) || dp[i][j] != -1) {
            continue;
          }
          dp[i][j] = dp[x][y] + 1;
          queue.add(new int[] {i, j});
        }
      }
      return dp;
    }
  }
}
