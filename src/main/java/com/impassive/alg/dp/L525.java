package com.impassive.alg.dp;

import java.util.HashMap;
import java.util.Map;

/** @author impassivey */
public class L525 {

  public static void main(String[] args) {
    int[] nums = {1, 0, 1, 1, -1, -1, -1};
    System.out.println(new Solution().findMaxLength(nums));
  }

  static class Solution {
    public int findMaxLength(int[] nums) {
      if (nums.length <= 1) {
        return 0;
      }
      // 代表出现和为 key 的时候，出现的位置在value
      Map<Integer, Integer> map = new HashMap<>(8);
      // 初始化的时候，出现和为 0 的位置，在 -1 处
      map.put(0, -1);
      int counter = 0;
      int max = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 1) {
          counter++;
        } else {
          counter--;
        }
        if (map.containsKey(counter)) {
          int pre = map.get(counter);
          max = Math.max(max, i - pre);
        } else {
          map.put(counter, i);
        }
      }
      return max;
    }
  }
}
