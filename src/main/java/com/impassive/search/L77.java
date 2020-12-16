package com.impassive.search;

import java.util.ArrayList;
import java.util.List;

/** @author impassivey */
public class L77 {

  public static void main(String[] args) {
    List<List<Integer>> combine = new Solution().combine(4, 2);
    System.out.println(combine);
  }

  static class Solution {
    public List<List<Integer>> combine(int n, int k) {
      if (n <= 0 || k <= 0) {
        return new ArrayList<>();
      }
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> values = new ArrayList<>();
      boolean[] marked = new boolean[n + 1];
      dfs(result, values, n, k, 1, marked);
      return result;
    }

    private void dfs(
        List<List<Integer>> result,
        List<Integer> values,
        int n,
        int k,
        int start,
        boolean[] marked) {
      if (values.size() == k) {
        result.add(new ArrayList<>(values));
        return;
      }
      for (int i = start; i <= n; i++) {
        if (marked[i]) {
          continue;
        }
        marked[i] = true;
        values.add(i);
        dfs(result, values, n, k, i + 1, marked);
        values.remove(values.size() - 1);
        marked[i] = false;
      }
    }
  }
}
