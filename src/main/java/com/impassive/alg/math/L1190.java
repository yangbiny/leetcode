package com.impassive.alg.math;

import java.util.Stack;

public class L1190 {

  public static void main(String[] args) {
    System.out.println(new Solution().reverseParentheses("(ed(et(oc))el)"));
  }

  static class Solution {
    public String reverseParentheses(String s) {
      Stack<String> stack = new Stack<>();
      StringBuilder str = new StringBuilder();
      char[] chars = s.toCharArray();
      for (char aChar : chars) {
        if (aChar != '(' && aChar != ')') {
          str.append(aChar);
        } else if (aChar == '(') {
          stack.push(str.toString());
          str.setLength(0);
        } else {
          str.reverse();
          str.insert(0, stack.pop());
        }
      }
      return str.toString();
    }
  }
}
