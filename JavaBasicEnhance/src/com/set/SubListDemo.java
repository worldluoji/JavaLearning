package com.set;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
* SubList 是原始 List 的视图，并不是独立的 List。
* 双方对元素的修改会相互影响，而且 SubList 强引用了原始的 List，所以大量保存这样的 SubList 会导致 OOM。
* */
public class SubListDemo {
    public static void main(String[] args) {
        List<Integer> list = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList()); // 1-10
        List<Integer> subList = list.subList(1, 4); // 2,3,4
        System.out.println(subList);
        subList.remove(1);
        System.out.println(list);
        /**
        * 原始 List 中数字 3 被删除了，说明删除子 List 中的元素影响到了原始 List；尝试为原始 List 增加数字 0 之后再遍历子 List，会出现 ConcurrentModificationException。
        * */
        list.add(0);
        try {
            subList.forEach(System.out::println);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
