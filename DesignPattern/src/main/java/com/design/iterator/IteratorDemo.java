package com.design.iterator;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
* 迭代器是用来遍历容器的，所以，一个完整的迭代器模式一般会涉及容器和容器迭代器两部分内容。
 * 实际上，foreach 循环只是一个语法糖而已，底层是基于迭代器来实现的
* */
public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<String> lst = Lists.newArrayList("chengdu","shanghai","suzhou");
        Iterator<String> it = new ArrayIterator<>(lst);
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
