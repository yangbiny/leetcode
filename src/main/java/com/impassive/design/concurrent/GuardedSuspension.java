package com.impassive.design.concurrent;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;
import lombok.Getter;

/** @author impassivey */
public class GuardedSuspension {

  public static void main(String[] args) {
    Guarded<Integer> guarded = Guarded.create(123);
    Guarded<Integer> value = new Guarded<>(234);
    Guarded.fire(guarded, value);
    Integer object = value.getObject(item -> Objects.equals(item, 234));
    System.out.println(object);
  }

  static class Guarded<T> {

    @Getter private T object;

    private final Lock lock = new ReentrantLock();

    private final Condition condition = lock.newCondition();

    // 记录每一个对象和他的
    private static final Map<Object, Guarded> GUARDED_MAP = new ConcurrentHashMap<>();

    public Guarded(T object) {
      this.object = object;
    }

    public Guarded() {}

    public static <K, T> Guarded<T> create(K key) {
      Guarded<T> value = new Guarded<>();
      GUARDED_MAP.put(key, value);
      return value;
    }

    public static <K, T> void fire(K key, T value) {
      @SuppressWarnings("unchecked")
      Guarded<T> guarded = GUARDED_MAP.remove(key);
      if (guarded != null) {
        guarded.changeObject(value);
      }
    }

    public T getObject(Predicate<T> test) {
      lock.lock();
      try {
        // 使用while是因为唤醒后需要再次确认条件是否满足
        while (!test.test(object)) {
          // 等待通知
          condition.await();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
      }
      return object;
    }

    public void changeObject(T object) {
      lock.lock();
      try {
        this.object = object;
        // 唤醒所有等待的线程
        condition.signalAll();
      } finally {
        lock.unlock();
      }
    }
  }
}
