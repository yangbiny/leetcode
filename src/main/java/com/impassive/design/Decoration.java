package com.impassive.design;

/**
 * 装饰器模式
 *
 * @author impassivey
 */
public class Decoration {

  public static void main(String[] args) {
    DecoratorInterface decoratorInterface = new DecoratorImpl();
    decoratorInterface.test();
    Decorator decorator = new Decorator(decoratorInterface);
    decorator.test();
  }

  public interface DecoratorInterface {
    /** 测试方法 */
    void test();
  }

  public static class DecoratorImpl implements DecoratorInterface {

    @Override
    public void test() {
      System.out.println("正常的实现类");
    }
  }

  /** 装饰器：通过组合的方式去扩展对象的行为 */
  public static class Decorator implements DecoratorInterface {

    private final DecoratorInterface decoratorInterface;

    public Decorator(DecoratorInterface decoratorInterface) {
      this.decoratorInterface = decoratorInterface;
    }

    @Override
    public void test() {
      System.out.println("decorator");
      decoratorInterface.test();
      System.out.println("decoration");
    }
  }
}
