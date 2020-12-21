package com.impassive.search;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** @author impassivey */
public class L127 {

  public static void main(String[] args) {
    int result =
        new Solution()
            .ladderLength(
                "hit", "cog", Lists.newArrayList("hot", "dot", "dog", "lot", "log", "cog"));
    System.out.println(result);
  }

  static class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      if (wordList == null || wordList.size() == 0) {
        return 0;
      }
      wordList.add(beginWord);
      int n = wordList.size();
      int start = n - 1;
      // 标记为结果的位置
      int end = 0;
      while (end < n && !wordList.get(end).equals(endWord)) {
        end++;
      }
      if (end == n) {
        return 0;
      }
      // 构造成一个图
      List<Integer>[] graph = buildGra(wordList);
      // 去遍历这个图
      return bfs(graph, start, end, wordList.size());
    }

    private int bfs(List<Integer>[] graph, int start, int end, int N) {
      Queue<Integer> queue = new LinkedList<>();
      queue.add(start);
      int result = 1;
      boolean[] marked = new boolean[N];
      marked[start] = true;
      while (!queue.isEmpty()) {
        int size = queue.size();
        result++;
        while (size > 0) {
          size--;
          Integer poll = queue.poll();
          for (Integer item : graph[poll]) {
            if (item == end) {
              return result;
            }
            if (marked[item]) {
              continue;
            }
            queue.add(item);
            marked[item] = true;
          }
        }
      }
      return 0;
    }

    private List<Integer>[] buildGra(List<String> wordList) {
      List<Integer>[] result = new ArrayList[wordList.size()];
      for (int i = 0; i < wordList.size(); i++) {
        result[i] = new ArrayList<>();
        for (int j = 0; j < wordList.size(); j++) {
          if (!connect(wordList.get(i), wordList.get(j))) {
            continue;
          }
          result[i].add(j);
        }
      }
      return result;
    }

    private boolean connect(String word1, String word2) {
      int result = 0;
      for (int i = 0; i < word1.length() && result < 2; i++) {
        if (word1.charAt(i) != word2.charAt(i)) {
          result++;
        }
      }
      return result == 1;
    }
  }
}
