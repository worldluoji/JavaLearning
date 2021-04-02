package com.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListRemoveEleDemo {
    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();
        lst.addAll(Arrays.asList(1,2,3,4,5,6));
        /**
        * 传入Integer是删除对应数值，如果是传入int基本类型，则是删除对应下标
         * 查看源码可以看到remove方法是被重载的，传入包装类型和基本类型不同的方法处理
        */
        Integer num = 3;
        lst.remove(num);
        lst.stream().forEach(System.out::println);
        lst.clear();
        lst.addAll(Arrays.asList(1,2,3,4,5,6));
        lst.remove(3);
        System.out.println("****************************");
        lst.stream().forEach(System.out::println);
    }
}
