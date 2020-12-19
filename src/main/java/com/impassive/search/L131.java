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
      if (s == null || s.length() == 0) {
        return new ArrayList<>();
      }
      List<List<String>> result = new ArrayList<>();
      dfs(result, new ArrayList<String>(), s);
      return result;
    }

    private void dfs(List<List<String>> result, List<String> values, String str) {
      if (str.length() == 0) {
        result.add(new ArrayList<>(values));
        return;
      }
      for (int i = 0; i < str.length(); i++) {
        if (isRollBackStr(str.substring(0, i + 1))) {
          values.add(str.substring(0, i + 1));
          dfs(result, values, str.substring(i + 1));
          values.remove(values.size() - 1);
        }
      }
    }

    private boolean isRollBackStr(String str) {
      if (str.length() == 0) {
        return false;
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
