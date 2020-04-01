package com.set;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysAsListDemo {
    public static void main(String[] args) {
        // 正确示例
        int[] arr1 = {1, 2, 3};
        List list1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        System.out.println(list1);
        System.out.println(list1.size());
        System.out.println(list1.getClass());
        System.out.println("********************");
        Integer[] arr2 = {1, 2, 3};
        // Arrays.asList返回的是arrays内部的ArrayList, 这是一个不可变的, 对原始数组的修改会影响到我们获得的那个 List
        List list2 = Arrays.asList(arr2);
        System.out.println(list2);
        System.out.println(list2.size());
        System.out.println(list2.getClass());
        arr2[1] = 6;
        System.out.println(list2);
        System.out.println("********************");
        // 错误示例，不能直接使用 Arrays.asList 来转换基本类型数组,将数据当成了一个元素，可以翻源码查看,入参为一个可变参数
        List list3= Arrays.asList(arr1);
        System.out.println(list3);
        System.out.println(list3.size());
        System.out.println(list3.getClass());
    }
}
