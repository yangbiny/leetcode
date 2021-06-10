package com.impassive.alg.nowcoder;

/** @author impassivey */
public class NewCoder3 {

  public static void main(String[] args) {
    int[][] map = {
      {0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0},
      {0, 0, 0, 1, 0},
      {0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0},
      {0, 0, 0, 0, 2},
    };
    System.out.println(new Visit().countPath(map, 7, 5));
  }

  public static class Visit {
    public int countPath(int[][] map, int n, int m) {
      int indexX = 0, indexY = 0;
      int endX = 0, endY = 0;
      for (int i = 0; i < map.length; i++) {
        for (int i1 = 0; i1 < map[i].length; i1++) {
          if (map[i][i1] == 1) {
            indexX = i;
            indexY = i1;
          }
          if (map[i][i1] == 2) {
            endX = i;
            endY = i1;
          }
        }
      }
      // 同一行或者同一列直接是1
      if (indexY == endY || indexX == endX) {
        return 1;
      }
      // 找到 x 最小的那个（因为从1 到 2 和从 2 到 1 是一样的）
      int beginX = indexX, beginY = indexY;
      if (endX < beginX) {
        beginX = endX;
        endX = indexX;
        beginY = endY;
        endY = indexY;
      }
      // 因为 x 上一定是往下移动，所以只需要判断 y 上是左还是右
      int cal = beginY > endY ? -1 : 1;
      int[][] dp = new int[n][m];
      dp[beginX][beginY] = 0;
      for (int i = beginX; i <= endX; i++) {
        for (int j = beginY; j <= endY && j >= 0; j += cal) {
          if (i == beginX && j == beginY){
            continue;
          }
          // 同一行或者同一列只能是1
          if (i == beginX || j == beginY) {
            dp[i][j] = 1;
            continue;
          }
          dp[i][j] = dp[i][j - cal] + dp[i - 1][j];
        }
      }
      return dp[endX][endY];
    }
  }
}
