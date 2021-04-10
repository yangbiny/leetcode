package com.impassive.alg.math;

/** @author impassivey */
public class L76 {

  public static void main(String[] args) {
    System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
  }

  static class Solution {
    public String minWindow(String s, String t) {
      int[] need = new int[128];
      for (int c : t.toCharArray()) {
        need[c]++;
      }

      int left = 0, right = 0, size = Integer.MAX_VALUE, needCnt = t.length(), start = 0;

      while (right < s.length()) {
        final char c = s.charAt(right);
        if (need[c] > 0) {
          needCnt--;
        }
        need[c]--;
        if (needCnt == 0) {
          while (left < right && need[s.charAt(left)] < 0) {
            need[s.charAt(left)]++;
            left++;
          }

          if (right - left + 1 < size) {
            size = right - left + 1;
            start = left;
          }
          need[s.charAt(left)]++;
          left++;
          needCnt++;
        }
        right++;
      }
      return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
  }
}
