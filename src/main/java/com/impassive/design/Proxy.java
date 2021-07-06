package com.impassive.design;

/**
 * 代理模式
 *
 * @author impassivey
 */
public class Proxy {

  public static void main(String[] args) {
    ProxyInterface proxyInterface = new ProxyObject();
    proxyInterface.test();
  }

  public interface ProxyInterface {

    /** test */
    void test();
  }

  public static class ProxyObject implements ProxyInterface {

    private ProxyInterface proxyInterface;

    @Override
    public void test() {
      if (proxyInterface == null) {
        proxyInterface = new RealObject();
      }
      proxyInterface.test();
    }
  }

  public static class RealObject implements ProxyInterface {

    @Override
    public void test() {
      System.out.println("真正的对象");
    }
  }
}
