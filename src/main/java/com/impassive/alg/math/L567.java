package com.impassive.alg.math;

import java.util.Arrays;
import java.util.Objects;

/** @author impassivey */
public class L567 {

  public static void main(String[] args) {
    System.out.println(new Solution().checkInclusion("abc", "dddbac"));
  }

  static class Solution {
    public boolean checkInclusion(String s1, String s2) {
      int n = s1.length(), m = s2.length();
      if (n > m) {
        return false;
      }
      int[] cnt1 = new int[26];
      int[] cnt2 = new int[26];
      // 先直接计算n的时候，每一个元素的个数
      for (int i = 0; i < n; ++i) {
        ++cnt1[s1.charAt(i) - 'a'];
        ++cnt2[s2.charAt(i) - 'a'];
      }
      if (Arrays.equals(cnt1, cnt2)) {
        return true;
      }

      //长度为n 的一个滑动窗口。
      // 计算长度为 n 的滑动窗口中，每一个元素的个数，与子串是否相同
      for (int i = n; i < m; ++i) {
        // 新纳入的数据的个数加1
        ++cnt2[s2.charAt(i) - 'a'];
        // 把窗口最前面的数据减1
        --cnt2[s2.charAt(i - n) - 'a'];
        if (Arrays.equals(cnt1, cnt2)) {
          return true;
        }
      }
      return false;
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
}*/

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
