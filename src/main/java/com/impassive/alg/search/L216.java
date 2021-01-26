package com.impassive.alg.search;

import java.util.ArrayList;
import java.util.List;

/** @author impassivey */
public class L216 {

  public static void main(String[] args) {
    List<List<Integer>> lists = new Solution().combinationSum3(3, 6);
    System.out.println(lists);
  }

  static class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
      List<List<Integer>> result = new ArrayList<>();
      dfs(result, new ArrayList<Integer>(), 1, n, k);
      return result;
    }

    private void dfs(
        List<List<Integer>> result, List<Integer> values, int start, Integer target, int maxNum) {
      if (0 == maxNum && target == 0) {
        result.add(new ArrayList<>(values));
        return;
      }
      if(0 == maxNum || target == 0){
        return;
      }
      for (int i = start; i < 10; i++) {
        values.add(i);
        dfs(result, values, i + 1, target - i, maxNum - 1);
        values.remove(values.size() - 1);
      }
    }
  }
}
