package com.equalsandhashcode;

import java.util.HashSet;
import java.util.Set;

/**
 *  对于自定义类，如果类型需要参与判等，那么务必同时实现 equals 和 hashCode 方法，并确保逻辑一致。
 * 如果希望快速实现 equals、hashCode 方法，我们可以借助 IDE 的代码生成功能，或使用 Lombok 来生成。
 * 如果类型也要参与比较，那么 compareTo 方法的逻辑同样需要和 equals、hashCode 方法一致。
* */
public class EqualsAndHashCodeDemo {
    public static void main(String[] args) {
        Point p1 = new Point(1,2, "test1");
        Point p2 = new Point(1,2, "test2");
        System.out.println(p1 == p2);
        System.out.println("p1 == p1 is " + p1.equals(p2));
        Set<Point> set = new HashSet<>();
        set.add(p1);
        System.out.println("set contains p2 is " + set.contains(p2));

    }
}
