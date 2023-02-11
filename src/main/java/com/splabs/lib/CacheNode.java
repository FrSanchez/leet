package com.splabs.lib;

public class CacheNode<K,V> {
    K key;
    V value;
    long expirationTimeStamp;

    public CacheNode(K key, V value, long expirationTimeStamp)
    {
        this.key = key;
        this.value = value;
        this.expirationTimeStamp = expirationTimeStamp;
    }

    @Override
    public String toString() {
        return value.toString() + " " + expirationTimeStamp;
    }
}
