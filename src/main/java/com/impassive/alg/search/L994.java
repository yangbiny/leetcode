package com.impassive.alg.search;

import java.util.LinkedList;
import java.util.Queue;

public class L994 {

  public static void main(String[] args) {
    int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
    System.out.println(new Solution().orangesRotting(grid));
  }

  static class Solution {

    private final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
      if (grid.length == 0 || grid[0].length == 0) {
        return -1;
      }
      boolean hasTwo = false;
      int cntOfOne = 0;
      Queue<int[]> queue = new LinkedList<>();
      for (int i = 0; i < grid.length; i++) {
        for (int i1 = 0; i1 < grid[i].length; i1++) {
          if (grid[i][i1] == 2) {
            hasTwo = true;
            queue.add(new int[] {i, i1});
          } else if (grid[i][i1] == 1) {
            cntOfOne++;
          }
        }
      }
      if (!hasTwo && cntOfOne == 0){
        return 0;
      }
      if (!hasTwo) {
        return -1;
      }
      int res = -1;
      int resOne = 0;
      while (!queue.isEmpty()) {
        int size = queue.size();
        res++;
        for (int i = 0; i < size; i++) {
          int[] poll = queue.poll();
          for (int[] ints : direction) {
            int x = poll[0] + ints[0];
            int y = poll[1] + ints[1];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
              continue;
            }
            if (grid[x][y] == 2 || grid[x][y] == 0) {
              continue;
            }
            grid[x][y] = 2;
            queue.add(new int[] {x, y});
            resOne++;
          }
        }
      }
      return resOne == cntOfOne ? res  : -1;
    }
  }
}
