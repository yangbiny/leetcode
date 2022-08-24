package com.impassive.words;

import com.impassive.words.base.NodeStatus;
import com.impassive.words.base.TrieTreeNode;
import java.io.File;
import java.io.IOException;
import java.util.Map.Entry;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.junit.Test;

public class TrieTreeTest {

  private static final String dataPath = "/Volumes/workspace/admin/leetcode/data/test.txt";

  @Test
  public void insert() throws IOException {

    TrieTree trieTree = new TrieTree();

    LineIterator iterator = FileUtils.lineIterator(new File(dataPath));
    while (iterator.hasNext()) {
      String next = iterator.nextLine();
      String[] s = next.split("\t");
      trieTree.insert(s[0].trim());
    }


    for (Entry<Character, TrieTreeNode> entry : trieTree.getRoot().getChildren().entrySet()) {
      if (entry.getValue().getStatus() != NodeStatus.normal){
        continue;
      }
      System.out.println(entry);
    }
  }
}