package com.impassive.alg.search;

public class L695 {

  public static void main(String[] args) {
    int[][] nums = {{0, 0, 0}, {0, 0, 0}};
    System.out.println(new Solution().maxAreaOfIsland(nums));
  }

  static class Solution {
    public int maxAreaOfIsland(int[][] grid) {
      int max = 0;
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
          if (grid[i][j] == 1) {
            max = Math.max(max, maxAreaOfIsland(grid, i, j));
          }
        }
      }
      return max;
    }
    public  int maxAreaOfIsland(int[][] grid, int x, int y) {
      if (x < 0 || x >= grid.length || y  <0 || y >= grid[x].length
          || grid[x][y] == 0) {
        return 0;
      }
      grid[x][y] = 0;
      int sum = 1;
      sum += maxAreaOfIsland(grid, x-1, y);
      sum += maxAreaOfIsland(grid, x+1, y);
      sum += maxAreaOfIsland(grid, x, y - 1);
      sum += maxAreaOfIsland(grid, x, y + 1);
      return sum;
    }
  }
}
