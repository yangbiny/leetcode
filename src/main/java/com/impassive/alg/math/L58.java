package com.impassive.alg.math;

/** @author impassivey */
public class L58 {

  public static void main(String[] args) {
    System.out.println(new Solution().lengthOfLastWord("  Hello "));
  }

  static class Solution {
    public int lengthOfLastWord(String s) {
      if (s.trim().length() == 0) {
        return 0;
      }
      char[] chars = s.toCharArray();
      int n = chars.length;
      int max = 0;
      for (int i = n - 1; i>=0;i--){
        if (chars[i] == ' '){
          if (max != 0){
            break;
          }
          continue;
        }
        max++;
      }
      return max;
    }
  }
}
