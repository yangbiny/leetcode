package com.impassive.alg.search;

public class L617 {

  public static void main(String[] args) {
    //
  }

  static class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
      if (root1 == null || root2 == null) {
        return root1 == null ? root2 : root1;
      }
      TreeNode merged = new TreeNode(root1.val + root2.val);
      merged.left = mergeTrees(root1.left, root2.left);
      merged.right = mergeTrees(root1.right, root2.right);
      return merged;
    }
  }
}
