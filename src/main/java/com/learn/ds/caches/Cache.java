package com.learn.ds.caches;

public interface Cache<K,V> {
  V get(K key);
  V put(K key, V val);
}
