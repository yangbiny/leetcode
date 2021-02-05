package com.impassive.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * 读写锁不允许出现锁的升级（即读锁升级为写锁），但是允许出现锁的降级（写锁降级为读锁）
 *
 * @author impassivey
 */
public class ReadWriteLockCache<K, V> {

  private final Map<K, V> dataMap;

  private final ReadLock readLock;

  private final WriteLock writeLock;

  public ReadWriteLockCache() {
    dataMap = new HashMap<>();
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    readLock = lock.readLock();
    writeLock = lock.writeLock();
  }

  public V getDataFromCache(K key) {
    readLock.lock();
    try {
      V value = dataMap.get(key);
      if (value != null) {
        return value;
      }
      // 如果没有找到锁，也不能再此处去查询添加，因为读锁未释放，会导致写锁无法获取。
    } finally {
      readLock.unlock();
    }
    // 去做其他的事情，获取value;
    // value = 其他操作
    // 再次验证数据是否有添加进去
    V value = dataMap.get(key);
    if (value != null) {
      putDataToCache(key, value);
    }
    return value;
  }

  public V putDataToCache(K key, V value) {
    writeLock.lock();
    try {
      return dataMap.put(key, value);
    } finally {
      writeLock.unlock();
    }
  }
}
