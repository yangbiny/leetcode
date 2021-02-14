package com.impassive.container;

import java.util.concurrent.ConcurrentSkipListMap;

/** @author impassivey */
public class ConcurrentSkipListMapTest {

  public static void main(String[] args) {
    ConcurrentSkipListMap<String, String> map = new ConcurrentSkipListMap<>();
    map.put("xx", "yy");
    System.out.println(map.size());
  }
}
