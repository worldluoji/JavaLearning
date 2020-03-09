package com.design.share;

import java.lang.reflect.InvocationTargetException;

public class ObjectPoolDemo {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InterruptedException {
        Class<?>[] classTypes = {String.class, int.class, String.class};
        Object[] prams = {"皮卡丘", 0, "东方奇骥"};
        ObjectPool<Pokemon, String> pokemonPool = new ObjectPool<>(6, Pokemon.class, classTypes, prams);
        pokemonPool.exec(t -> {
            System.out.println(t);
            return t.toString();
        });
    }
}
