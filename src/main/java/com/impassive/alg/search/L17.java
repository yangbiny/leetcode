package com.impassive.alg.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @see <a
 *     href="https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/">leetcode</a>
 * @author impassivey
 */
public class L17 {

  private static final String[] KEY = {
    "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
  };

  public static void main(String[] args) {
    List<String> strings = new Solution().letterCombinations("234");
    System.out.println(strings);
  }

  static class Solution {
    public List<String> letterCombinations(String digits) {
      if (digits == null || digits.length() == 0) {
        return Collections.emptyList();
      }
      List<String> result = new ArrayList<>();
      StringBuilder builder = new StringBuilder();
      dfs(result, builder, digits);
      return result;
    }

    private void dfs(List<String> result, StringBuilder str, String digits) {
      if (str.length() == digits.length()) {
        result.add(str.toString());
        return;
      }
      char c = digits.charAt(str.length());
      String temp = KEY[c - '0'];
      for (char c1 : temp.toCharArray()) {
        str.append(c1);
        dfs(result, str, digits);
        str.deleteCharAt(str.length() - 1);
      }
    }
  }
}
