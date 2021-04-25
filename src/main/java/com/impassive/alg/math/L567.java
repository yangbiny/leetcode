package com.impassive.alg.math;

import java.util.Arrays;
import java.util.Objects;

/** @author impassivey */
public class L567 {

  public static void main(String[] args) {
    System.out.println(new Solution().checkInclusion("abc", "bac"));
  }

  static class Solution {
    public boolean checkInclusion(String s1, String s2) {
      if (s1.length() == 0) {
        return true;
      }
      boolean result = false;
      int s1Len = s1.length();

      int[] chars = new int[26];
      for (char c : s1.toCharArray()) {
        ++chars[c - 'a'];
      }

      final int length = s2.toCharArray().length;
      for (int i = 0; i < length; i++) {
        if (s1.contains(s2.charAt(i) + "")) {
          String temp;
          if (i + s1Len <= length) {
            temp = s2.substring(i, i + s1Len);
            result = check(chars, temp);
          }
          if (!result && i - s1Len >= 0) {
            temp = s2.substring(i - s1Len, i);
            result = check(chars, temp);
          }
        }
        if (result) {
          return true;
        }
      }

      return false;
    }

    private boolean check(int[] chars, String temp) {
      int[] tempChar = new int[26];
      final char[] chars1 = temp.toCharArray();
      for (char c : chars1) {
        ++tempChar[c - 'a'];
      }
      return Arrays.equals(tempChar, chars);
    }
  }
}

/*class Solution {
  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() == 0) {
      return true;
    }
    boolean result = false;
    int s1Len = s1.length();
    final int length = s2.toCharArray().length;
    for (int i = 0; i < length; i++) {
      if (s1.contains(s2.charAt(i) + "")) {
        String temp;
        if (i + s1Len <= length) {
          temp = s2.substring(i, i + s1Len);
          result = check(s1, temp);
        }
        if (!result && i - s1Len >= 0) {
          temp = s2.substring(i - s1Len, i);
          result = check(s1, temp);
        }
      }
      if (result){
        return true;
      }
    }

    return false;
  }

  private boolean check(String s1, String temp) {
    final char[] chars = s1.toCharArray();
    final char[] chars1 = temp.toCharArray();
    Arrays.sort(chars);
    Arrays.sort(chars1);
    return Objects.equals(new String(chars), new String(chars1));
  }
}*/
