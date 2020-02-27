package com.design.decorator;

import java.io.*;

/**
*  装饰器类和原始类继承同样的父类，这样我们可以对原始类“嵌套”多个装饰器类。
 * 比如，下面这样一段代码，我们对 FileInputStream 嵌套了两个装饰器类：BufferedInputStream 和 DataInputStream
 * 让它既支持缓存读取，又支持按照基本数据类型来读取数据。
* */
public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\JavaLearning\\DesignPattern\\src\\main\\java\\com\\design\\utils\\output\\temp\\testReadInt.txt";
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filePath)));
        out.writeInt(123); // 这里用了writeInt,读的时候也要用readInt相对应，否则会因为序列化问题导致读出奇怪的结果
        out.flush();
        out.close();
        InputStream in = new FileInputStream(filePath);
        InputStream bin = new BufferedInputStream(in);
        DataInputStream din = new DataInputStream(bin);
        int data = din.readInt();
        System.out.println(data);
        din.close();
    }
}
