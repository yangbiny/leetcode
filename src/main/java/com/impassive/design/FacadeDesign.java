package com.impassive.design;

/**
 * 外观模式
 *
 * @author impassivey
 */
public class FacadeDesign {

  public static void main(String[] args) {
    Facade facade = new RealClass();
    facade.facade();
  }

  private interface Facade {

    /** 外观模式的调用入口 */
    void facade();
  }

  private static class RealClass implements Facade {

    public void doSomeThing() {
      System.out.println("do some thing");
    }

    @Override
    public void facade() {
      // 真正完成业务逻辑的地方
      doSomeThing();
    }
  }
}
