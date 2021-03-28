package com.impassive.alg.math;

import java.util.Arrays;

/** @author impassivey */
public class L344 {

  public static void main(String[] args) {
    String str = "hell";
    final char[] chars = str.toCharArray();
    new Solution().reverseString(chars);
    System.out.println(Arrays.toString(chars));
  }

  static class Solution {
    public void reverseString(char[] s) {
      if (s.length == 0 || s.length == 1) {
        return;
      }
      int start = 0, end = s.length - 1;
      while (start < end) {
        char a = s[start];
        s[start] = s[end];
        s[end] = a;
        end--;
        start++;
      }
    }
  }
}
