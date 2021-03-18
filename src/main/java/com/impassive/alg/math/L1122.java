package com.impassive.alg.math;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/** @author impassivey */
public class L1122 {

  public static void main(String[] args) {
    int[] arr1 = {7, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
    int[] arr2 = {2, 1, 4, 3, 9, 6};
    System.out.println(Arrays.toString(new Solution().relativeSortArray(arr1, arr2)));
  }

  static class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
      Map<Integer, Integer> map = new TreeMap<>();
      for (int arr : arr1) {
        Integer integer = map.getOrDefault(arr, 0);
        map.put(arr, ++integer);
      }
      int[] result = new int[arr1.length];
      int index = 0;
      for (int arr : arr2) {
        for (int i = 0; i < map.get(arr); i++) {
          result[index++] = arr;
        }
        map.remove(arr);
      }
      for (Integer integer : map.keySet()) {
        for (int i = 0; i < map.get(integer); i++) {
          result[index++] = integer;
        }
      }
      return result;
    }
  }
}
