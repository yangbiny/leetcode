package com.impassive.alg.math;

/** @author impassivey */
public class L3 {

  public static void main(String[] args) {
    System.out.println(new Solution().lengthOfLongestSubstring("jbpnbwwd"));
  }

  static class Solution {
    public int lengthOfLongestSubstring(String s) {
      if (s.length() == 0) {
        return 0;
      }
      String result = s.charAt(0) + "";
      String tempResult = s.charAt(0) + "";
      int n = s.length();
      int beginIndex = 0;
      for (int i = 1; i < n; i++) {
        String temp = "";
        final int chatIndex = tempResult.indexOf(s.charAt(i));
        if (chatIndex != -1) {
          beginIndex = beginIndex + chatIndex + 1;
        }
        if (beginIndex < i + 1) {
          temp = s.substring(beginIndex, i + 1);
        }
        tempResult = temp;
        if (tempResult.length() >= result.length()){
          result = tempResult;
        }
      }
      return result.length();
    }
  }
}
