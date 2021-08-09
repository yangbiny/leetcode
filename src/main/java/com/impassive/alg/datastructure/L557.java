package com.impassive.alg.datastructure;

public class L557 {

  public static void main(String[] args) {
    System.out.println(new Solution().reverseWords("hello word"));
  }

  static class Solution {
    public String reverseWords(String s) {
      if (s == null || s.length() == 0) {
        return s;
      }
      String[] strings = s.split(" ");
      StringBuilder sb = new StringBuilder();
      for (String string : strings) {
        String s1 = reverseString(string);
        if (s1 != null && s1.length() != 0) {
          sb.append(s1);
        }
        sb.append(" ");
      }
      return sb.toString().trim();
    }

    public String reverseString(String str) {
      char[] s = str.toCharArray();
      if (s.length == 0 || s.length == 1) {
        return str;
      }
      int start = 0, end = s.length - 1;
      while (start < end) {
        char a = s[start];
        s[start] = s[end];
        s[end] = a;
        end--;
        start++;
      }
      return new String(s);
    }
  }
}
