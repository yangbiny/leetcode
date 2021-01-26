package com.impassive.alg.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/restore-ip-addresses/">leetcode</a>
 * @author impassivey
 */
public class L93 {

  public static void main(String[] args) {
    List<String> strings = new Solution().restoreIpAddresses("25525511135");
    System.out.println(strings);
  }

  static class Solution {
    public List<String> restoreIpAddresses(String s) {
      StringBuilder builder = new StringBuilder();
      List<String> result = new ArrayList<>();
      dfs(0, builder, result, s);
      return result;
    }

    /**
     * 递归解析一个数字字符串可能生成的IP地址信息
     *
     * @param k 当前的IP段，例如10.1 时，k为2
     * @param str 当前生成的字符串信息
     * @param result 结果集
     * @param s 需要用于生成IP信息的数字字符串
     */
    private void dfs(int k, StringBuilder str, List<String> result, String s) {
      if (k == 4 || s.length() == 0) {
        if (k == 4 && s.length() == 0) {
          result.add(str.toString());
        }
        return;
      }

      for (int i = 0; i < s.length() && i <= 2; i++) {
        // 如果第一个是0但是当前的数字不是第一个开始（即012）
        if (i != 0 && s.charAt(0) == '0') {
          break;
        }
        String temp = s.substring(0, i + 1);
        // 当前的数字需要小于等于255才是可用的
        if (Integer.parseInt(temp) <= 255) {
          if (str.length() != 0) {
            temp = "." + temp;
          }
          str.append(temp);
          dfs(k + 1, str, result, s.substring(i + 1));
          str.delete(str.length() - temp.length(), str.length());
        }
      }
    }
  }
}
