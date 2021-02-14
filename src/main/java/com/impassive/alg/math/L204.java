package com.impassive.alg.math;

/** @author impassivey */
public class L204 {

  public static void main(String[] args) {
    System.out.println(new Solution().countPrimes(100));
  }

  static class Solution {
    public int countPrimes(int n) {
      boolean[] temp = new boolean[n + 1];
      int cnt = 0;
      for (int i = 2; i < n; i++) {
        if (temp[i]) {
          continue;
        }
        cnt++;
        for (long j = (long) i * i; j < n; j += i) {
          temp[(int) j] = true;
        }
      }
      return cnt;
    }
  }
}
