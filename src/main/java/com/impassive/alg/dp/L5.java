package com.impassive.alg.dp;

/** @author impassivey */
public class L5 {

  public static void main(String[] args) {
    System.out.println(new Solution().longestPalindrome("ba"));
  }

  static class Solution {
    public String longestPalindrome(String s) {
      if (s.length() == 0 || s.length() == 1) {
        return s;
      }
      String result = s.charAt(0)+"";
      int n = s.length();
      for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
          String substring = s.substring(i, j + 1);
          if (check(substring)) {
            result = result.length() > substring.length() ? result : substring;
          }
        }
      }
      return result;
    }

    private boolean check(String s) {
      int n = s.length() - 1;
      int i = 0;
      while (i < n) {
        if (s.charAt(i) != s.charAt(n)) {
          return false;
        }
        i++;
        n--;
      }
      return true;
    }
  }
}
