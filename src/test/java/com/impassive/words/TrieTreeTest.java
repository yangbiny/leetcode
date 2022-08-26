package com.impassive.words;

import com.impassive.words.base.Range;
import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.junit.Before;
import org.junit.Test;

public class TrieTreeTest {

  private static final String dataPath = "/Volumes/workspace/admin/leetcode/data/CoreNatureDictionary.txt";

  private TrieTree trieTree;

  @Before
  public void setUp() throws Exception {
    trieTree = new TrieTree();
    LineIterator iterator = FileUtils.lineIterator(new File(dataPath));
    while (iterator.hasNext()) {
      String next = iterator.nextLine();
      String[] s = next.split("\t");
      trieTree.insert(s[0].trim());
    }
  }

  @Test
  public void insert() throws IOException {

  }

  @Test
  public void testParse() {

    String text = "这个东西是用来测试一号机器是否正确";
    trieTree.parseText(text, new Consumer<Range>() {
      @Override
      public void accept(Range range) {
        String substring = text.substring(range.getBegin(), range.getEnd() + 1);
        System.out.println(substring);
      }
    });
  }
}