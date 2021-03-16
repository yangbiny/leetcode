package com.impassive.alg.dp;

/** @author impassivey */
public class L5 {

  public static void main(String[] args) {
    System.out.println(new Solution().longestPalindrome("baab"));
  }

  static class Solution {
    public String longestPalindrome(String s) {
      if (s.length() == 0 || s.length() == 1) {
        return s;
      }
      String result = s.charAt(0) + "";
      int n = s.length();
      int start = 0;
      while (start < n) {
        String temp = check(s, start, start);
        String temp1 = check(s, start, start + 1);
        result = result.length() > temp.length() ? result : temp;
        result = result.length() > temp1.length() ? result : temp1;
        start++;
      }
      return result;
    }

    private String check(String s, int start, int end) {
      int n = s.length();
      while (start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
        start--;
        end++;
      }
      return s.substring(start + 1, end);
    }
  }
}
