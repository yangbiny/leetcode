package com.impassive.alg.datastructure;

import lombok.Data;

/** @author impassivey */
public class ListNode {

   int val;

   ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
