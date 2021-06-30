package com.impassive.design;

/**
 * 简单工厂模式
 *
 * @author impassivey
 */
public class EasyFactory {

  public static void main(String[] args) {
    Factory factory = new Factory();
    factory.build(1).test();
  }

  public static class Factory {

    /**
     * 工厂的实现。如果base是1，则返回odd，如果是2，则返回even，否则返回other
     *
     * @param base 需要判别的值
     * @return 工厂生产的对象
     */
    public FactoryInterface build(Integer base) {
      switch (base) {
        case 1:
          return new OddNumber();
        case 2:
          return new EvenNumber();
        default:
          return new OtherNumber();
      }
    }
  }

  public interface FactoryInterface {

    /** test */
    void test();
  }

  public static class OtherNumber implements FactoryInterface {

    @Override
    public void test() {
      System.out.println("otherNumber");
    }
  }

  public static class EvenNumber implements FactoryInterface {

    @Override
    public void test() {
      System.out.println("evenNumber");
    }
  }

  public static class OddNumber implements FactoryInterface {

    @Override
    public void test() {
      System.out.println("oddNumber");
    }
  }
}
