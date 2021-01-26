package com.impassive.alg.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** @author impassivey */
public class L39 {

  public static void main(String[] args) {
    int[] can = {2, 3, 6, 7};
    List<List<Integer>> lists = new Solution().combinationSum(can, 7);
    System.out.println(lists);
  }

  static class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> values = new ArrayList<>();
      Arrays.sort(candidates);
      dfs(result, values, target, 0, candidates);
      return result;
    }

    private void dfs(
        List<List<Integer>> result, List<Integer> values, int target, int start, int[] candidates) {
      if (target <= 0) {
        if (target == 0) {
          result.add(new ArrayList<>(values));
        }
        return;
      }
      for (int i = start; i < candidates.length; i++) {
        values.add(candidates[i]);
        dfs(result, values, target - candidates[i], i, candidates);
        values.remove(values.size() - 1);
      }
    }
  }
}
