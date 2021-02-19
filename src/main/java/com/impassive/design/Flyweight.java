package com.impassive.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 享元模式：如果系统中存在有多个相同的对象，则这多个对象共享一个对象的拷贝，不用为每一次对象的拷贝创建一个新的对象
 *
 * @author impassivey
 */
public class Flyweight {

  public static void main(String[] args) {
    List<TempString> tempStrings = new ArrayList<>();
    StringFactory stringFactory = StringFactory.getBookFactoryInstance();
    tempStrings.add(stringFactory.buildStr("test1"));
    tempStrings.add(stringFactory.buildStr("test2"));
    tempStrings.add(stringFactory.buildStr("test3"));
    tempStrings.add(stringFactory.buildStr("test4"));
    tempStrings.add(stringFactory.buildStr("test2"));
    tempStrings.add(stringFactory.buildStr("test2"));
    tempStrings.add(stringFactory.buildStr("test3"));
    tempStrings.add(stringFactory.buildStr("test4"));
    tempStrings.add(stringFactory.buildStr("test1"));
    for (TempString tempString : tempStrings) {
      String x = tempString.subString(0, 1);
      stringFactory.buildStr(x);
      System.out.println(x);
    }
    System.out.println(stringFactory.strTypes());
  }

  /** 享元模式中定义一个对象的操作方式 */
  interface TempString {

    /**
     * 此处定义字符串的截取
     *
     * @param start 开始的位置
     * @param end 结束的位置
     * @return 新的字符串
     */
    String subString(int start, int end);
  }

  /** 具体的一个对象 */
  static class MyString implements TempString {
    private final String name;

    public MyString(String name) {
      this.name = name;
    }

    @Override
    public String subString(int start, int end) {
      char[] chars = this.name.toCharArray();
      char[] chars1 = Arrays.copyOfRange(chars, start, end);
      return new String(chars1);
    }
  }

  /** 维护对象列表 */
  static class StringFactory {
    private final Map<String, MyString> strMap = new HashMap<>();

    private static final StringFactory BOOK_FACTORY = new StringFactory();

    private StringFactory() {}

    public static StringFactory getBookFactoryInstance() {
      return BOOK_FACTORY;
    }

    /**
     * @param string str
     * @return string的信息
     */
    public MyString buildStr(String string) {
      MyString bookOrder = strMap.get(string);
      if (bookOrder != null) {
        return bookOrder;
      }
      bookOrder = new MyString(string);
      strMap.put(string, bookOrder);
      return bookOrder;
    }

    public int strTypes() {
      return strMap.size();
    }
  }
}
