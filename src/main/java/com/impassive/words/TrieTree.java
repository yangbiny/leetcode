package com.impassive.words;

import com.impassive.words.base.NodeStatus;
import com.impassive.words.base.TrieTreeNode;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

public class TrieTree {

  @Getter
  private final TrieTreeNode root;

  public TrieTree() {
    root = new TrieTreeNode();
  }

  public void insert(String word) {
    if (StringUtils.isEmpty(word)) {
      return;
    }

    TrieTreeNode node = root;
    char[] chars = word.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      NodeStatus status = NodeStatus.normal;
      if (i == chars.length - 1) {
        status = NodeStatus.words;
      }
      node = node.insert(chars[i], status);
    }

  }


  public void parseText(String text) {
    if (StringUtils.isEmpty(text)) {
      return;
    }
  }
}
