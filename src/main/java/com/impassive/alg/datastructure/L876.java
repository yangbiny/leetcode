package com.impassive.alg.datastructure;

import java.util.List;

public class L876 {

  public static void main(String[] args) {
    //
  }

  static class Solution {
    public ListNode middleNode(ListNode head) {
      if (head == null) {
        return head;
      }
      int cnt = 0;
      ListNode node = head;
      while (node != null) {
        cnt++;
        node = node.next;
      }
      int index = cnt / 2;
      while (index > 0){
        head = head.next;
        index--;
      }
      return head;
    }
  }
}
