package com.impassive.alg.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** @author impassivey */
public class L47 {

  public static void main(String[] args) {
    int[] nums = {1,1,2};
    List<List<Integer>> lists = new Solution().permuteUnique(nums);
    System.out.println(lists);
  }

  static class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
      if (nums == null || nums.length == 0) {
        return new ArrayList<>();
      }
      Arrays.sort(nums);
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> values = new ArrayList<>();
      boolean[] marked = new boolean[nums.length];
      dfs(result,values,marked,nums);
      return result;
    }

    private void dfs(
        List<List<Integer>> result, List<Integer> values, boolean[] marked, int[] nums) {
      if (values.size() == nums.length) {
        result.add(new ArrayList<>(values));
        return;
      }
      for (int i = 0; i < nums.length; i++) {
        if (marked[i]){
          continue;
        }
        if (i > 0 && nums[i] == nums[i - 1] && marked[i - 1]) {
          continue;
        }
        values.add(nums[i]);
        marked[i] = true;
        dfs(result, values, marked, nums);
        values.remove(values.size() - 1);
        marked[i] = false;
      }
    }
  }
}
