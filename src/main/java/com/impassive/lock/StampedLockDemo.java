package com.impassive.lock;

import java.util.concurrent.locks.StampedLock;

/** @author impassivey */
public class StampedLockDemo {

  private int x, y;

  private final StampedLock stampedLock = new StampedLock();

  public void check() {
    // 去获取一个乐观锁
    // 实际上并没有加锁
    // 加上乐观锁的时候，是允许有一个线程进行写操作。
    long stamp = stampedLock.tryOptimisticRead();

    int curX = x;
    int curY = y;

    // 去验证是否有线程进行了数据的修改，有的话，则升级为悲观读锁
    if (!stampedLock.validate(stamp)) {
      long readStamp = stampedLock.readLock();
      try{
        curX = x;
        curY = y;
      }finally{
        stampedLock.unlockRead(readStamp);
      }
    }
  }
}
