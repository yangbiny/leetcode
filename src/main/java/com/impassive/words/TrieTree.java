package com.impassive.words;

import com.impassive.words.base.NodeStatus;
import com.impassive.words.base.Range;
import com.impassive.words.base.TrieTreeNode;
import java.util.function.Consumer;
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

  public boolean contains(String word) {
    if (StringUtils.isEmpty(word)) {
      return false;
    }

    char[] chars = word.toCharArray();
    TrieTreeNode node = root;
    for (char aChar : chars) {
      if (node == null) {
        break;
      }
      node = node.searchNode(aChar);
    }
    return node != null && node.checkIsWords();
  }

  public void parseText(String text, Consumer<Range> consumer) {
    if (StringUtils.isEmpty(text)) {
      return;
    }
    char[] chars = text.toCharArray();

    for (int i = 0; i < chars.length; i++) {
      TrieTreeNode trieTreeNode = root.searchNode(chars[i]);
      if (trieTreeNode == null) {
        continue;
      }

      for (int j = i + 1; j < chars.length; j++) {
        trieTreeNode = trieTreeNode.searchNode(chars[j]);
        if (trieTreeNode == null) {
          break;
        }
        if (trieTreeNode.checkIsWords()) {
          consumer.accept(new Range(i, j));
        }
      }
    }
  }
}
