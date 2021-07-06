package com.impassive.design;

/**
 * 工厂方法模式：提供一个创建工厂的方法，该方法会最终的去创建出一个具体的对象。对于后续新增的时候，无需修改工厂，对修改关闭。缺点是需要客户端知道每一个工厂
 *
 * @author impassivey
 */
public class Factory {

  public static void main(String[] args) {
    FactoryInterface factoryInterface = new EasyProductFactory();
    factoryInterface.createProduct().test();
    factoryInterface = new DifficultProductFactory();
    factoryInterface.createProduct().test();
  }

  public interface Product {

    /** 测试 */
    void test();
  }

  public interface FactoryInterface {
    /**
     * 创建产品
     *
     * @return 创建的产品信息
     */
    Product createProduct();
  }

  public static class EasyProductFactory implements FactoryInterface {

    @Override
    public Product createProduct() {
      return new EaseProduct();
    }
  }

  public static class DifficultProductFactory implements FactoryInterface {

    @Override
    public Product createProduct() {
      return new DifficultProduct();
    }
  }

  public static class EaseProduct implements Product {

    @Override
    public void test() {
      System.out.println("easy");
    }
  }

  public static class DifficultProduct implements Product {

    @Override
    public void test() {
      System.out.println("difficult");
    }
  }
}
