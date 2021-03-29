package com.impassive.alg.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** @author impassivey */
public class L103 {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    final List<List<Integer>> lists = new Solution().zigzagLevelOrder(root);
    System.out.println(lists);
  }

  static class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      if (root == null) {
        return Collections.emptyList();
      }
      List<List<Integer>> result = new ArrayList<>();
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      boolean left = true;
      while (!queue.isEmpty()) {
        List<Integer> tempResult = new ArrayList<>();
        int size = queue.size();
        while (size > 0) {
          size--;
          final TreeNode peek = queue.poll();
          if (peek == null) {
            continue;
          }
          queue.add(peek.left);
          queue.add(peek.right);
          tempResult.add(peek.val);
        }
        if (left) {
          left = false;
        } else {
          Collections.reverse(tempResult);
          left = true;
        }
        if (tempResult.isEmpty()){
          continue;
        }
        result.add(tempResult);
      }
      return result;
    }
  }
}
