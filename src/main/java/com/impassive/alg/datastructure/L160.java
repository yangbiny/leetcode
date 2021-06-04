package com.impassive.alg.datastructure;

/** @author impassivey */
public class L160 {

  public static void main(String[] args) {
    //
  }

  public static class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      if (headA == null || headB == null) {
        return null;
      }
      ListNode listA = headA, listB = headB;
      while (listA != null && listB != null) {
        if (listA == listB) {
          return listA;
        }
        listA = listA.next;
        listB = listB.next;
      }
      ListNode tpA = headA, tpB = headB;
      while (listA != null) {
        listA = listA.next;
        tpA = tpA.next;
      }
      while (listB != null) {
        listB = listB.next;
        tpB = tpB.next;
      }
      while (tpA != null && tpB != null) {
        if (tpA == tpB) {
          return tpA;
        }
        tpA = tpA.next;
        tpB = tpB.next;
      }
      return null;
    }
  }
}
