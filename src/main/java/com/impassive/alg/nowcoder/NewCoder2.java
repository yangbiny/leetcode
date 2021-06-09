package com.impassive.alg.nowcoder;

import java.util.Arrays;
import org.apache.commons.collections4.ArrayStack;

/** @author impassivey */
public class NewCoder2 {

  public static void main(String[] args) {
    int[][] a = {{0, 0, 1, 1}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 1, 0}},
        b = {{2, 2}, {3, 3}, {4, 4}};
    System.out.println(Arrays.deepToString(new Flip().flipChess(a, b)));
  }

  public static class Flip {

    private int[][] test = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

    public int[][] flipChess(int[][] A, int[][] f) {
      // write code here
      for (int[] p : f) {
        for (int[] ints : test) {
          int x = p[0] + ints[0] - 1;
          int y = p[1] + ints[1] - 1;
          if (x >= 0 && x < 4 && y >= 0 && y < 4) {
            A[x][y] = getVal(A[x][y]);
          }
        }
      }
      return A;
    }

    private int getVal(int val) {
      return val == 1 ? 0 : 1;
    }
  }
}
