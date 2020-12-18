package com.impassive.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** @author impassivey */
public class L90 {

  public static void main(String[] args) {
    int[] nums = {1, 2, 2};
    List<List<Integer>> lists = new Solution().subsetsWithDup(nums);
    System.out.println(lists);
  }

  static class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      Arrays.sort(nums);
      List<List<Integer>> result = new ArrayList<>();
      result.add(new ArrayList<Integer>());
      boolean[] marked = new boolean[nums.length];
      for (int i = 1; i <= nums.length; i++) {
        dfs(result, new ArrayList<Integer>(), i, 0, marked, nums);
      }
      return result;
    }

    private void dfs(
        List<List<Integer>> result,
        List<Integer> values,
        int k,
        int start,
        boolean[] marked,
        int[] nums) {

      if (k == values.size()) {
        result.add(new ArrayList<>(values));
        return;
      }
      for (int i = start; i < nums.length; i++) {
        if (i > 0 && nums[i] == nums[i - 1] && !marked[i - 1]) {
          continue;
        }
        marked[i] = true;
        values.add(nums[i]);
        dfs(result, values, k, i + 1, marked, nums);
        values.remove(values.size() - 1);
        marked[i] = false;
      }
    }
  }
}
