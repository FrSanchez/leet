package com.splabs.lib;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CacheTest {
    @BeforeEach
    public void init() {

    }
    @Test
    public void testOne() {
        Cache<String, String> cache = new Cache<String,String>(10);
        for(char c = 'A'; c <= 'L'; c++) {
            cache.set(c +  "", c + "", Cache.getCurrentTimeStamp() + 100 + c);
        }
        CacheNode<String, String> node = cache.get("B");
        assertNull(node);
    }

    @Test
    public void testTwo() {
        Cache<String, String> cache = new Cache<String,String>(10);
        for(char c = 'A'; c <= 'Z'; c++) {
            cache.set(c +  "", c + "", Cache.getCurrentTimeStamp() + 100* c);
        }

        CacheNode<String, String> node = cache.get("Z");
        assertEquals("Z", node.value);
    }

    @Test
    public void testPQ() {
        Cache<String, String> cache = new Cache<String,String>(10);
        for(char c = 'A'; c <= 'Z'; c++) {
            cache.set(c +  "", c + "", Cache.getCurrentTimeStamp() + (100 * ( c%3 - 2  )));
        }
        CacheNode<String, String> node = cache.get("Z");
        assertEquals("Z", node.value);
    }

    @Test
    public void testRemoveOld() {
        Cache<String, String> cache = new Cache<String,String>(50);
        cache.set("A", "A", Cache.getCurrentTimeStamp() + 10000);
        for(int i  = 0; i < 50; i++) {
            cache.set("" + i, "" + i, i);
        }
        CacheNode<String, String> node = cache.get( "A");
        assertEquals("A", node.value);
    }
}
