package com.concurrent;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class ConcurrentHashMapDemo {
    private Map<Integer, String> cache = new ConcurrentHashMap<>();
    public static void main(String[] args) {
        ConcurrentHashMapDemo demo = new ConcurrentHashMapDemo();
        demo.test();
    }

    public void test() {
        cache.putIfAbsent(1, "成都");
        cache.putIfAbsent(2, "苏州");
        cache.putIfAbsent(3, "上海");
        cache.putIfAbsent(3, "北京");
        Function<Integer, String> f = s -> s % 2 == 0?"重庆":"武汉";
        cache.computeIfAbsent(4, f);
        cache.computeIfAbsent(5, f);
        Iterator<Map.Entry<Integer, String>> it = cache.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> e = it.next();
            System.out.println(e.getValue() + ":" + e.getKey());
        }
    }
}
