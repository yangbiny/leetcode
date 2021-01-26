package com.impassive.design;

/** @author impassivey */
public class Single {

  /**
   * 加volatile是为了防止指令重排序
   *
   * <p>防止指令重排是因为JVM在初始化对象的时候，指令重排下，会先去申请一块内存，然后将内存地址赋值给对象，然后初始化。 此时如果有线程直接获取成功，会导致空指针
   */
  private static volatile Single single;

  private Single() {}

  public static Single getInstance() {
    if (single != null) {
      return single;
    }
    synchronized (Single.class) {
      // 再次判断是因为获取到锁的时候，可能已经被其他线程初始化了
      if (single == null) {
        single = new Single();
      }
    }
    return single;
  }
}
