package com.impassive.alg.datastructure.bit;

/** @author impassivey */
public class L461 {

  public static void main(String[] args) {
    System.out.println(new Solution().hammingDistance(1,4));
  }

  static class Solution {
    public int hammingDistance(int x, int y) {
      return Integer.bitCount(x ^ y);
    }
  }
}
