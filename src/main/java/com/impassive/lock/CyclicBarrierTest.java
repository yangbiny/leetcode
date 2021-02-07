package com.impassive.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/** @author impassivey */
public class CyclicBarrierTest {

  public static void main(String[] args) throws InterruptedException {
    CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> System.out.println("xx"));
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
              try {
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName());
              } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
              }
              count.countDown();
            });
    thread1.start();
    Thread thread2 =
        new Thread(
            () -> {
              try {
                Thread.sleep(40000);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
              try {
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName());
              } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
              }
              count.countDown();
            });
    thread2.start();
    count.await();
    System.out.println(System.currentTimeMillis());
  }
}
