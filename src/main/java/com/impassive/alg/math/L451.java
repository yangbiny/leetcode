package com.impassive.alg.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** @author impassivey */
public class L451 {

  public static void main(String[] args) {
    System.out.println(new Solution().frequencySort("cccaaa"));
  }

  static class Solution {
    public String frequencySort(String s) {
      if (s.length() == 0) {
        return s;
      }
      final char[] chars = s.toCharArray();
      int[] charCnt = new int[128];
      for (char aChar : chars) {
        charCnt[aChar]++;
      }
      Map<Integer, List<Character>> charMap = new HashMap<>(s.length());
      for (int i = 0; i < charCnt.length; i++) {
        if (charCnt[i] == 0) {
          continue;
        }
        final List<Character> characters = charMap.getOrDefault(charCnt[i], new ArrayList<>());
        characters.add((char) i);
        charMap.put(charCnt[i], characters);
      }
      final ArrayList<Integer> list = new ArrayList<>(charMap.keySet());
      Collections.sort(list);
      char[] result = new char[s.length()];
      int index = 0;
      for (int i = list.size() - 1; i >= 0; i--) {
        final Integer key = list.get(i);
        final List<Character> characters = charMap.get(key);
        if (characters == null) {
          continue;
        }
        for (Character character : characters) {
          for (int j = 0; j < key; j++) {
            result[index++] = character;
          }
        }
      }
      return new String(result);
    }
  }
}
