package com.impassive.alg.datastructure;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Stack;

/** @author impassivey */
public class L445 {

  public static void main(String[] args) {
    ListNode l1 = null;
    ListNode head1 = null;
    List<Integer> array1 = Lists.newArrayList(7, 2, 4, 3);
    List<Integer> array2 = Lists.newArrayList(7, 5, 6, 4);
    for (Integer integer : array1) {
      if (l1 == null) {
        l1 = new ListNode(integer);
        head1 = l1;
        continue;
      }
      l1.next = (new ListNode(integer));
      l1 = l1.next;
    }
    ListNode l2 = null;
    ListNode head2 = null;
    for (Integer integer : array2) {
      if (l2 == null) {
        l2 = new ListNode(integer);
        head2 = l2;
        continue;
      }
      l2.next = (new ListNode(integer));
      l2 = l2.next;
    }
    final ListNode node = new Solution().addTwoNumbers(head1, head2);
    System.out.println(node);
  }

  static class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      if (l1 == null || l2 == null) {
        return l1 == null ? l1 : l2;
      }
      Stack<Integer> s1 = new Stack<>();
      while (l1 != null) {
        s1.push(l1.val);
        l1 = l1.next;
      }
      Stack<Integer> s2 = new Stack<>();
      while (l2 != null) {
        s2.push(l2.val);
        l2 = l2.next;
      }
      ListNode head = null;
      int nextVal = 0;
      while (!s1.empty() || !s2.empty() || nextVal != 0) {
        final int val = (s1.empty() ? 0 : s1.pop()) + (s2.empty() ? 0 : s2.pop()) + nextVal;
        ListNode node = new ListNode(val % 10);
        node.next = head;
        nextVal = val / 10;
        head = node;
      }
      return head;
    }

  }
}
