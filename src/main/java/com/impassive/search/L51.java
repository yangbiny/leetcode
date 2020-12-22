package com.impassive.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.units.qual.A;

/** @author impassivey */
public class L51 {

  public static void main(String[] args) {
    List<List<String>> lists = new Solution().solveNQueens(6);
    System.out.println(lists);
  }

  static class Solution {
    public List<List<String>> solveNQueens(int n) {
      if (n == 0) {
        return new ArrayList<>();
      }
      boolean[] marked45 = new boolean[2 * n - 1];
      boolean[] marked135 = new boolean[2 * n - 1];
      boolean[] markedCol = new boolean[n];
      List<List<String>> result = new ArrayList<>();
      String[][] temp = new String[n][n];
      dfs(0, n, temp, marked45, marked135, markedCol, result);
      return result;
    }

    private void dfs(
        int row,
        int n,
        String[][] temp,
        boolean[] marked45,
        boolean[] marked135,
        boolean[] markedCol,
        List<List<String>> result) {
      if (row == n) {
        List<String> tempRes = new ArrayList<>();
        for (String[] strings : temp) {
          StringBuilder builder = new StringBuilder();
          for (String string : strings) {
            if (string == null){
              string = ".";
            }
            builder.append(string);
          }
          tempRes.add(builder.toString());
        }
        result.add(tempRes);
        return;
      }
      for (int col = 0; col < n; col++) {
        if (markedCol[col] || marked45[row + col] || marked135[n - 1 - (row - col)]) {
          continue;
        }
        markedCol[col] = marked45[row + col] = marked135[n - 1 - (row - col)] = true;
        temp[row][col] = "Q";
        dfs(row + 1, n, temp, marked45, marked135, markedCol, result);
        markedCol[col] = marked45[row + col] = marked135[n - 1 - (row - col)] = false;
        temp[row][col] = ".";
      }
    }
  }
}
