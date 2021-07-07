package com.impassive.design;

/**
 * 原型模式
 *
 * @author impassivey
 */
public class Prototype {

  public static void main(String[] args) {
    EasyPrototype easyPrototype = new EasyPrototype();
    easyPrototype.setAge("10");
    EasyPrototype protoTypeInterface = (EasyPrototype) easyPrototype.cloneTest();
    protoTypeInterface.setAge("11");
    System.out.println(easyPrototype.age);
    System.out.println(protoTypeInterface.age);
  }

  public interface ProtoTypeInterface {

    /**
     * 克隆
     *
     * @return 克隆出来的对象
     */
    ProtoTypeInterface cloneTest();
  }

  public static class EasyPrototype implements ProtoTypeInterface {

    private String age;

    public EasyPrototype() {}

    public EasyPrototype(EasyPrototype easyPrototype) {
      this.age = easyPrototype.age;
    }

    public void setAge(String age) {
      this.age = age;
    }

    @Override
    public ProtoTypeInterface cloneTest() {
      return new EasyPrototype(this);
    }
  }
}
