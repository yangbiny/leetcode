package com.impassive.alg.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** @author impassivey */
public class L144 {

  public static void main(String[] args) {}

  static class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
      if (root == null) {
        return Collections.emptyList();
      }
      List<Integer> result = new ArrayList<>();
      process(root, result);
      return result;
    }

    private void process(TreeNode root, List<Integer> result) {
      if (root == null){
        return;
      }
      result.add(root.val);
      process(root.left, result);
      process(root.right, result);
    }
  }
}
