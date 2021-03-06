package com.impassive.alg.datastructure;

/** @author impassivey */
public class L19 {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode temp = head;
    for (int i = 2; i <= 5; i++) {
      temp.next = new ListNode(i);
      temp = temp.next;
    }
    ListNode listNode = new Solution().removeNthFromEnd(head, 1);
  }

  static class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
      if (head == null) {
        return null;
      }
      ListNode quick = head;
      while (n-- > 0) {
        quick = quick.next;
      }
      if (quick == null){
        return head.next;
      }
      ListNode temp = head;
      while (quick.next != null) {
        temp = temp.next;
        quick = quick.next;
      }
      temp.next = temp.next.next;
      return head;
    }
  }
}
