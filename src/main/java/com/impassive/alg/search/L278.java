package com.impassive.alg.search;

public class L278 {

  public static void main(String[] args) {
    System.out.println(new L278().firstBadVersion(2, 2));
  }

  public int firstBadVersion(int n, int bad) {
    int min = 1, max = n;
    while (min <= max) {
      int mid = (max - min) / 2 + min;
      if (isBadVersion(mid, bad)) {
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }
    return -1;
  }

  private boolean isBadVersion(int i1, int bad) {
    return bad == i1;
  }
}
