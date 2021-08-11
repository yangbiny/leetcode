package com.impassive.alg.search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class L733 {

  public static void main(String[] args) {
    int[][] nums = {{0, 0, 0}, {0, 0, 0}};
    System.out.println(Arrays.deepToString(new Solution().floodFill(nums, 0, 0, 2)));
  }

  static class Solution {

    private final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
      int xLength = image.length;
      int yLength = image[0].length;int old = image[sr][sc];
      Pair pair = new Pair(sr, sc);
      boolean[][] check = new boolean[xLength][yLength];
      Queue<Pair> queue = new LinkedList<>();
      queue.add(pair);
      while (!queue.isEmpty()) {
        Pair poll = queue.poll();
        image[poll.x][poll.y] = newColor;
        for (int[] ints : direction) {
          int x = poll.x + ints[0];
          int y = poll.y + ints[1];
          if (x < 0 || x >= xLength || y < 0 || y >= yLength){
            continue;
          }
          if (image[x][y] == old && !check[x][y]) {
            check[x][y] = true;
            queue.add(new Pair(x, y));
          }
        }
      }
      return image;
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
}
