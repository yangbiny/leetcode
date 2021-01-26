package com.impassive.alg.search;

import java.util.ArrayList;
import java.util.List;

/** @author impassivey */
public class L46 {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    List<List<Integer>> permute = new Solution().permute(nums);
    System.out.println(permute);
  }

  static class Solution {
    public List<List<Integer>> permute(int[] nums) {
      if (nums == null || nums.length == 0) {
        return new ArrayList<>();
      }
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> values = new ArrayList<>();
      boolean[] marked = new boolean[nums.length];
      dfs(nums, values, result, marked);
      return result;
    }

    private void dfs(
        int[] nums, List<Integer> values, List<List<Integer>> result, boolean[] marked) {
      if (values.size() == nums.length) {
        result.add(new ArrayList<>(values));
        return;
      }
      for (int i = 0; i < nums.length; i++) {
        if (marked[i]) {
          continue;
        }
        marked[i] = true;
        values.add(nums[i]);
        dfs(nums, values, result, marked);
        values.remove(values.size() - 1);
        marked[i] = false;
      }
    }
  }
}
