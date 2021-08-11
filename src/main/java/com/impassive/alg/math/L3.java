package com.impassive.alg.math;

/** @author impassivey */
public class L3 {

  public static void main(String[] args) {
    System.out.println(new Solution().lengthOfLongestSubstring("jbpnbwwd"));
  }

  static class Solution {
    public int lengthOfLongestSubstring(String s) {
      if (s.length() <= 1) {
        return s.length();
      }
      String result = "";
      String tempResult = "";
      int start = 0;
      for (int i = 0; i < s.length(); i++) {
        String temp = "";
        char charAt = s.charAt(i);
        int indexOf = tempResult.indexOf(charAt);
        if (indexOf > -1) {
          start = start + indexOf + 1;
        }
        if (start < i + 1) {
          temp = s.substring(start, i + 1);
        }
        tempResult = temp;
        if (tempResult.length() > result.length()){
          result = temp;
        }
      }
      return result.length();
    }
  }
}
