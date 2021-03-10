package com.impassive.alg.datastructure;

import java.util.Random;

/** @author impassivey */
public class SkipList {

  private static final Random RANDOM = new Random();

  private static final int MAX_LEVEL = 128;

  /** 保存头部的信息 */
  private final Node head;

  /** 保存尾部的信息 */
  private final Node tail;

  public SkipList() {
    head = new Node(1, -1);
    tail = new Node(1, -1);
    head.next = tail;
    tail.prev = head;
  }

  public void add(Integer value) {
    int level = randomLevel();
    Node node = new Node(level, value);
  }

  public Integer search(Integer key) {
    if (head == null) {
      return null;
    }
    return head.data;
  }

  public Integer searchRev(Integer key) {
    if (tail == null) {
      return null;
    }
    return tail.data;
  }

  /**
   * 根据key和value查找对应的节点。如果找到了key相同的对象，则会比较value的值，如果都想等，则直接返回，如果不想等，就返回最接近的前一个对象。
   *
   * @param value 需要查找的value
   * @return 返回的对象
   */
  private Node searchSkipNode(Integer value) {
    return null;
  }

  private int randomLevel() {
    return RANDOM.nextInt(MAX_LEVEL) + 1;
  }

  static class Node {

    protected Integer data;

    protected Node next;

    protected Node prev;

    protected Integer maxLevel;

    // 包含了每一层的数据信息
    protected Node[] nodes;

    public Node(Integer maxLevel, Integer data) {
      this.maxLevel = maxLevel;
      this.nodes = new Node[maxLevel];
      this.data = data;
    }

    public boolean equals(Integer value) {
      if (data == null) {
        return false;
      }
      return data.equals(value);
    }
  }
}
