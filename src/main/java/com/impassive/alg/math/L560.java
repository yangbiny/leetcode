package com.impassive.alg.math;

import java.util.HashMap;
import java.util.Map;

/** @author impassivey */
public class L560 {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    System.out.println(new Solution().subarraySum(nums, 3));
  }

  static class Solution {
    public int subarraySum(int[] nums, int k) {
      int result = 0;
      Map<Integer, Integer> map = new HashMap<>();
      map.put(0, 1);
      int pre = 0;
      for (int num : nums) {
        pre += num;
        if (map.containsKey(pre - k)) {
          result += map.get(pre - k);
        }
        map.put(pre, map.getOrDefault(pre, 0) + 1);
      }
      return result;
    }
  }
}
