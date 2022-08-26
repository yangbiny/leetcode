package com.impassive.words.base;

import it.unimi.dsi.fastutil.chars.Char2ObjectOpenHashMap;
import javax.annotation.Nullable;
import lombok.Data;
import lombok.Getter;
import org.apache.commons.collections4.MapUtils;

@Data
public class TrieTreeNode {

  private NodeStatus status;

  @Getter
  private Char2ObjectOpenHashMap<TrieTreeNode> children;

  public TrieTreeNode insert(char value, NodeStatus status) {
    if (MapUtils.isEmpty(children)) {
      children = new Char2ObjectOpenHashMap<>();
    }
    TrieTreeNode exist = children.get(value);
    if (exist != null) {
      return exist;
    }
    TrieTreeNode trieTreeNode = new TrieTreeNode();
    trieTreeNode.status = status;
    children.put(value, trieTreeNode);
    return trieTreeNode;
  }

  @Nullable
  public TrieTreeNode searchNode(Character chars) {
    if (MapUtils.isEmpty(children)) {
      return null;
    }
    return children.get(chars.charValue());
  }
}
