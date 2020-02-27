package com.design.decorator;

import com.design.utils.output.FileOutputUtil;

import java.io.IOException;

/**
* Java IO相关类使用或者借鉴了装饰器设计模式的思想
* */
public class FileOutputUtilsTestDemo {
    public static void main(String[] args) throws IOException {
        FileOutputUtil fileOutputUtil = new FileOutputUtil("D:\\JavaLearning\\DesignPattern\\src\\main\\java\\com\\design\\utils\\output\\temp");
        fileOutputUtil.output("这是测试数据1...","测试输出1");
    }
}
