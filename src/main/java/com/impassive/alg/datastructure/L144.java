package com.impassive.alg.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/** @author impassivey */
public class L144 {

  public static void main(String[] args) {}

  static class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
      if (root == null) {
        return Collections.emptyList();
      }
      List<Integer> result = new ArrayList<>();
      Stack<TreeNode> treeNodes = new Stack<>();
      treeNodes.add(root);
      while (!treeNodes.empty()) {
        final TreeNode pop = treeNodes.pop();
        if (pop == null){
          continue;
        }
        treeNodes.push(pop.right);
        treeNodes.push(pop.left);
        result.add(pop.val);
      }
      return result;
    }

    /**
     * 递归遍历
     *
     * @param root 根节点
     * @param result 结果集
     */
    private void process(TreeNode root, List<Integer> result) {
      if (root == null) {
        return;
      }
      result.add(root.val);
      process(root.left, result);
      process(root.right, result);
    }
  }
}
