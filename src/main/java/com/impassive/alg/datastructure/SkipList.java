package com.impassive.alg.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/** @author impassivey */
public class SkipList<T, V> {

  private static final Random RANDOM = new Random();

  /** 保存头部的信息 */
  private final SkipNode head;

  /** 保存尾部的信息 */
  private final SkipNode tail;

  public SkipList() {
    head = new SkipNode();
    tail = new SkipNode();
    head.next = tail;
    tail.prev = head;
  }

  public void add(T key, V value) {
    SkipNode skipNode = searchSkipNode(key, value);
    if (skipNode == null) {

      return;
    }
    if (skipNode.equals(key, value)) {}
  }

  public V search(T key) {
    if (head == null) {
      return null;
    }
    return head.node.value;
  }

  public V searchRev(T key) {
    if (tail == null) {
      return null;
    }
    return tail.node.value;
  }

  /**
   * 根据key和value查找对应的节点。如果找到了key相同的对象，则会比较value的值，如果都想等，则直接返回，如果不想等，就返回最接近的前一个对象。
   *
   * @param key 需要查找的key
   * @param value 需要查找的value
   * @return 返回的对象
   */
  private SkipNode searchSkipNode(T key, V value) {
    return null;
  }

  private boolean addLayer() {
    return RANDOM.nextBoolean();
  }

  class SkipNode {

    protected Node node;

    protected SkipNode next;

    protected SkipNode prev;

    // 包含了每一层的数据信息
    protected List<SkipNode> layer;

    public SkipNode() {
      layer = new ArrayList<>();
    }

    public boolean equals(T key, V value) {
      if (node == null) {
        return false;
      }
      return node.equals(key, value);
    }
  }

  class Node {
    protected T key;
    protected V value;

    public Node(T key, V value) {
      this.key = key;
      this.value = value;
    }

    protected boolean equals(T key, V value) {
      return Objects.equals(key, this.key) && Objects.equals(value, this.value);
    }
  }
}
