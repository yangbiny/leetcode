package com.impassive.lock;

import java.util.concurrent.CountDownLatch;

/** @author impassivey */
public class CountDownLatchTest {

  public static void main(String[] args) throws InterruptedException {
    CountDownLatch count = new CountDownLatch(2);
    System.out.println(System.currentTimeMillis());
    Thread thread1 =
        new Thread(
            () -> {
              try {
                Thread.sleep(1000);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
              count.countDown();
            });
    thread1.start();
    Thread thread2 =
        new Thread(
            () -> {
              try {
                Thread.sleep(4000);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
              count.countDown();
            });
    thread2.start();
    count.await();
    System.out.println(System.currentTimeMillis());
  }
}
