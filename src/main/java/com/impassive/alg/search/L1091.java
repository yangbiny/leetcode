package com.impassive.alg.search;

/** @author impassivey */
public class L1091 {

  public static void main(String[] args) {
    int[][] grid = {};
    int result = new Solution().shortestPathBinaryMatrix(grid);
    System.out.println(result);
  }

  static class Solution {

    private int[][] direction = {
      {-1, 0}, {-1, 1}, {-1, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {0, -1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
     /* if (grid.length == 0 || grid[0].length == 0) {
        return -1;
      }
      if (grid[0][0] == 1) {
        return -1;
      }
      Queue<Pair<Integer, Integer>> pairs = new LinkedList<>();
      pairs.add(new Pair<>(0, 0));
      int result = 0;
      while (!pairs.isEmpty()) {
        int size = pairs.size();
        result++;
        while (size > 0) {
          size--;
          Pair<Integer, Integer> poll = pairs.poll();
          if(poll == null){
            return -1;
          }
          for (int[] items : direction) {
            Integer key = poll.getKey();
            Integer value = poll.getValue();
            if (key == grid.length - 1 && value == grid[0].length - 1) {
              return result;
            }
            int nx = key + items[0];
            int ny = value + items[1];
            if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) {
              continue;
            }
            if (grid[nx][ny] == 1) {
              continue;
            }
            pairs.add(new Pair<>(nx, ny));
            grid[nx][ny] = 1;
          }
        }
      }*/
      return -1;
    }
  }
}
