package com.impassive.search;

import java.util.ArrayList;
import java.util.List;

/** @author impassivey */
public class L78 {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    List<List<Integer>> subsets = new Solution().subsets(nums);
    System.out.println(subsets);
  }

  static class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      result.add(new ArrayList<Integer>());
      for (int i = 1; i <= nums.length; i++) {
        dfs(result, new ArrayList<Integer>(), nums, i, 0);
      }
      return result;
    }

    private void dfs(
        List<List<Integer>> result, List<Integer> values, int[] nums, int k, int start) {
      if (values.size() == k) {
        result.add(new ArrayList<>(values));
        return;
      }
      for (int i = start; i < nums.length; i++) {
        values.add(nums[i]);
        dfs(result, values, nums, k, i + 1);
        values.remove(values.size() - 1);
      }
    }
  }
}
