package com.impassive.alg.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-paths/">leetcode</a>
 * @author impassivey
 */
public class L257 {

  public static void main(String[] args) {
    List<String> strings = new Solution().binaryTreePaths(null);
    System.out.println(strings);
  }

  static class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
      if (root == null) {
        return Collections.emptyList();
      }
      List<Integer> values = new ArrayList<>();
      List<String> result = new ArrayList<>();
      dfs(root, values, result);
      return result;
    }

    private void dfs(TreeNode root, List<Integer> values, List<String> result) {
      if (root == null) {
        return;
      }
      values.add(root.val);
      if (isLeaf(root)) {
        result.add(buildPath(values));
      } else {
        dfs(root.left, values, result);
        dfs(root.right, values, result);
      }
      values.remove(values.size() - 1);
    }

    private boolean isLeaf(TreeNode node) {
      return node.left == null && node.right == null;
    }

    private String buildPath(List<Integer> values) {
      StringBuilder str = new StringBuilder();
      for (int i = 0; i < values.size(); i++) {
        str.append(values.get(i));
        if (i != values.size() - 1) {
          str.append("->");
        }
      }
      return str.toString();
    }
  }
}
