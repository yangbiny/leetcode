package com.impassive.alg.datastructure;

/** @author impassivey */
public class L24 {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode temp = head;
    for (int i = 2; i <= 5; i++) {
      temp.next = new ListNode(i);
      temp = temp.next;
    }
    System.out.println(new Solution().swapPairs(head));
  }

  static class Solution {
    public ListNode swapPairs(ListNode head) {
      if (head == null){
        return head;
      }
      ListNode node = new ListNode(-1);
      node.next = head;
      ListNode pre = node;
      while (pre.next != null && pre.next.next != null){
        ListNode l1 = pre.next, l2 = pre.next.next;
        ListNode next = l2.next;
        l1.next = next;
        l2.next = l1;
        pre.next = l2;

        pre = l1;
      }
      return node.next;
    }
  }
}
