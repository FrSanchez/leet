package com.splabs.lib;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Cache<K,V> {

    PriorityQueue<CacheNode<K,V>> queue ;
    Map<K, CacheNode<K,V>> cache;
    int capacity;
    public Cache(int capacity) {
        cache = new HashMap<>();
        queue = new PriorityQueue<>(capacity, Comparator.comparingLong(cacheNode -> cacheNode.expirationTimeStamp));
        this.capacity = capacity;
    }

    public CacheNode<K,V> get(K key) {
        if (cache.containsKey(key)) {
            if (cache.get(key).expirationTimeStamp >= getCurrentTimeStamp()) {
                return cache.get(key);
            }
            cache.remove(key);
        }
        return null;
    }

    public void set(K key, V value, long expirationTimeStamp) {
        if (cache.size() >= this.capacity) {
            System.err.println(queue);
            while(queue.peek() != null &&
                    (cache.size() >= this.capacity || queue.peek().expirationTimeStamp < getCurrentTimeStamp())) {
                System.err.println(cache);
                CacheNode<K,V> node = queue.poll();
                if (node != null) {
                    cache.remove(node.key);
                }
            }
        }
        CacheNode<K,V> node = new CacheNode<>(key, value, expirationTimeStamp);
        cache.put(key, node);
        queue.add(node);
    }

    public static long getCurrentTimeStamp() {
        return System.currentTimeMillis() / 1000L;
    }
}
