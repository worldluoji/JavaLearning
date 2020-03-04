package com.design.combine;

/**
* 这里讲的“组合模式”，主要是用来处理树形结构数据。这里的“数据”，你可以简单理解为一组对象集合
 * 与其说是一种设计模式，倒不如说是对业务场景的一种数据结构和算法的抽象。
 * 其中，数据可以表示成树这种数据结构，业务需求可以通过在树上的递归遍历算法来实现。
* */
public class CombineDemo {
    public static void main(String[] args) {
        String path = "D:\\SpringBootDemo\\springbootdemo\\simple-jdbc\\src\\main\\java\\com\\jdbc\\simplejdbc";
        DirNode node = new DirNode(path);
        node.addNode(new SingleFile("D:\\SpringBootDemo\\springbootdemo\\simple-jdbc\\src\\main\\java\\com\\jdbc\\simplejdbc\\Foo.java"));
        node.addNode(new SingleFile("D:\\SpringBootDemo\\springbootdemo\\simple-jdbc\\src\\main\\java\\com\\jdbc\\simplejdbc\\FooDao.java"));
        System.out.println(node.countNumOfFiles());
        System.out.println(node.countSizeOfFiles());
    }
}
