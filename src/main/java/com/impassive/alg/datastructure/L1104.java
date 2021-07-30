package com.impassive.alg.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;

/** @author impassivey */
public class L1104 {

  public static void main(String[] args) {

    List<Integer> x = new Solution().pathInZigZagTree(26);
    System.out.println(x);
  }

  static class Solution {
    public List<Integer> pathInZigZagTree(int label) {
      List<Integer> result = new LinkedList<>();
      // 1. 计算在第几行
      int lines = calLines(label);
      // 2. 计算该行的最大和最小值

      int max = (int) (Math.pow(2, lines) - 1);
      int length = (int) Math.pow(2, lines - 1);
      int min = (max - length) + 1;
      int index = label - (max - min);
      boolean need = false;
      if (lines % 2 == 0) {
        index = length - index + 1;
        need = true;
      }
      int val;
      while (lines > 0) {

        if (length == 1) {
          result.add(0, 1);
          break;
        } else if (need) {
          // 奇数的时候，是倒序的，但是一定要还index，因为下一次会根据index去算他的父节点的index
          int temp = index;
          index = length - index + 1;
          val = min + index - 1;
          index = temp;
          need = false;
        } else {
          need = true;
          val = min + index - 1;
        }

        result.add(0, val);
        lines--;

        // 计算父节点行的信息
        max = min - 1;
        length = (int) Math.pow(2, lines - 1);
        min = (max - length) + 1;

        // 计算父节点的index
        double rs = index / 2.0;
        index = (int) Math.ceil(rs);
      }
      return result;
    }

    private int calLines(int label) {
      if (label == 1) {
        return 1;
      }
      for (int i = 1; ; i++) {
        if (Math.pow(2, i) - 1 >= label && Math.pow(2, i - 1) - 1 < label) {
          return i;
        }
      }
    }
  }
}
