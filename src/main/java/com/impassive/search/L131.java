package com.impassive.search;

import java.util.ArrayList;
import java.util.List;

/** @author impassivey */
public class L131 {

  public static void main(String[] args) {
    List<List<String>> result = new Solution().partition("acca");
    System.out.println(result);
  }

  static class Solution {
    public List<List<String>> partition(String s) {
      if(s == null || s.length() == 0){
        return new ArrayList<>();
      }
      List<List<String>> result = new ArrayList<>();
      backtrack(result, new ArrayList<String>(), s);
      return result;
    }

    private void backtrack(List<List<String>> result, List<String> values, String str) {
      if (str.length() == 0) {
        result.add(new ArrayList<>(values));
        return;
      }

      for (int i = 0; i < str.length(); i++) {
        String sub = str.substring(0, i + 1);
        if (palindrome(sub)) {
          values.add(sub);
          backtrack(result, values, str.substring(i + 1));
          values.remove(values.size() - 1);
        }
      }
    }

    private boolean palindrome(String str) {
      if (str.length() == 0) {
        return true;
      }
      int start = 0;
      int end = str.length() - 1;
      while (start < end) {
        if (str.charAt(start) != str.charAt(end)) {
          return false;
        }
        start++;
        end--;
      }
      return true;
    }
  }
}
