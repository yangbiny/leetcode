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
      LinkedList<Pair> queue = new LinkedList<>();
      boolean first = false;
      for (int i = 0; i < length; i++) {
        for (int j = 0; j < yLength; j++) {
          if (mat[i][j] == 0) {
            dp[i][j] = 0;
          } else {
            Pair e = new Pair(i, j);
            if (!first) {
              if (i - 1 > 0 && mat[i - 1][j] == 0) {
                first = addFirst(queue,e);
              } else if (j - 1 > 0 && mat[i][j - 1] == 0) {
                first = addFirst(queue,e);
              } else if (i + 1 < length && mat[i + 1][j] == 0) {
                first = addFirst(queue, e);
              } else if (j + 1 < yLength && mat[i][j + 1] == 0) {
                first = addFirst(queue,e);
              } else {
                queue.add(e);
              }
            } else {
              queue.add(e);
            }
          }
        }
      }
      while (!queue.isEmpty()) {
        Pair poll = queue.poll();
        int min = Integer.MAX_VALUE;
        for (int[] ints : direction) {
          int x = ints[0] + poll.x;
          int y = ints[1] + poll.y;
          if (x < 0 || y < 0 || x >= length || y >= yLength) {
            continue;
          }
          if (dp[x][y] == -1) {
            continue;
          }
          min = Math.min(min, dp[x][y]);
        }
        dp[poll.x][poll.y] = min + 1;
      }
      return dp;
    }

    private boolean addFirst(LinkedList<Pair> queue, Pair e) {
      if (queue.isEmpty()){
        queue.add(e);
        return true;
      }
      Pair pair = queue.get(0);
      queue.set(0, e);
      queue.add(pair);
      return true;
    }
  }

  static class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
