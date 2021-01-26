package com.impassive.alg.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** @author impassivey */
public class L279 {

  public static void main(String[] args) {
    int result = new Solution().numSquares(14);
    System.out.println(result);
  }

  static class Solution {
    public int numSquares(int n) {
      if(n < 4){
        return n;
      }
      List<Integer> integers = generateSquareN(n);
      Queue<Integer> queue = new LinkedList<>();
      queue.add(n);
      boolean[] marked = new boolean[n + 1];
      int result = 0;
      while (!queue.isEmpty()){
        result++;
        int size = queue.size();
        while (size > 0){
          size--;
          Integer temp = queue.poll();
          if(temp == null){
            continue;
          }
          for (Integer integer : integers) {
            int tmp = temp - integer;
            if(tmp == 0){
              return result;
            }
            if(tmp < 0){
              continue;
            }
            if (marked[tmp]){
              continue;
            }
            marked[tmp] = true;
            queue.add(tmp);
          }
        }

      }
      return -1;
    }

    private List<Integer> generateSquareN(int n) {
      List<Integer> result = new ArrayList<>();
      int temp = 1, diff = 1;
      while (temp <= n) {
        result.add(temp);
        diff += 2;
        temp += diff;
      }
      return result;
    }
  }
}
