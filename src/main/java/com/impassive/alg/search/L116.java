package com.impassive.alg.search;

import java.util.LinkedList;
import java.util.Queue;

public class L116 {

  public static void main(String[] args) {
    Node root = new Node(1);
    Node left = new Node(2);
    left.left = new Node(4);
    left.right = new Node(5);
    root.left = left;
    Node right = new Node(3);
    right.left = new Node(6);
    right.right = new Node(7);
    root.right = right;

    System.out.println(new Solution().connect(root));
  }

  static class Solution {
    public Node connect(Node root) {
      Queue<Node> queue = new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          Node next = queue.poll();

          if (i < size - 1) {
            next.next = queue.peek();
          }
          if (next.left != null) {
            queue.add(next.left);
          }
          if (next.right != null) {
            queue.add(next.right);
          }
        }
      }
      return root;
    }
  }
}
