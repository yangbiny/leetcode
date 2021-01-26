package com.impassive.alg.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** @author impassivey */
public class L40 {

  public static void main(String[] args) {
    int[] can = {2,5,2,1,2};
    List<List<Integer>> lists = new Solution().combinationSum2(can, 5);
    System.out.println(lists);
  }

  static class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      if (candidates == null || candidates.length == 0 || target == 0) {
        return new ArrayList<>();
      }
      Arrays.sort(candidates);
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> values = new ArrayList<>();
      boolean[] marked = new boolean[candidates.length];
      dfs(result, values, 0, candidates, target, marked);
      return result;
    }

    private void dfs(
        List<List<Integer>> result,
        List<Integer> values,
        int start,
        int[] candidates,
        int target,
        boolean[] marked) {
      if (target <= 0) {
        if (target == 0) {
          result.add(new ArrayList<>(values));
        }
        return;
      }
      for (int i = start; i < candidates.length; i++) {
        if (i != 0 && candidates[i - 1] == candidates[i] && !marked[i - 1]) {
          continue;
        }
        marked[i] = true;
        values.add(candidates[i]);
        dfs(result, values, i + 1, candidates, target - candidates[i], marked);
        values.remove(values.size() - 1);
        marked[i] = false;
      }
    }
  }
}
