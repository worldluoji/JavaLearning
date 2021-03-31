package com.equalsandhashcode;

import java.util.Objects;


/**
*  关于equals其实还有一个大坑，equals比较的对象除了所谓的相等外，还有一个非常重要的因素，就是该对象的类加载器也必须是同一个，
 *  不然equals返回的肯定是false；之前遇到过一个坑：重启后，两个对象相等，结果是true，但是修改了某些东西后，
 *  热加载（不用重启即可生效）后，再次执行equals，返回就是false，因为热加载使用的类加载器和程序正常启动的类加载器不同。
 *  关于类加载器部分，JDK 9 之前的 Java 应用都是由「启动类加载器」、「扩展类加载器」、「应用程序类加载器」这三种类加载器互相配合来完成加载的，如果有需要还可以加入自定义的类加载器来进行拓展；
 *  JDK 9 为了模块化的支持，对双亲委派模式做了一些改动：扩展类加载器被平台类加载器（Platform ClassLoader）取代。平台类加载器和应用程序类加载器都不再继承自 java.net.URLClassLoader，而是继承于 jdk.internal.loader.BuiltinClassLoader。
 *
 * instanceof进行类型检查规则是:你是该类或者是该类的子类；
 * getClass获得类型信息采用==来进行检查是否相等的操作是严格的判断。不会存在继承方面的考虑；
 *
 * HashSet本质上就是HashMap的key组成的不重复的元素集合，contains方法其实就是根据hashcode和equals去判断相等的
 * TreeSet本质TreeMap的key组成的，数据结构是红黑树，是自带排序功能的，可以在放入元素的时候指定comparator（比较器），
 * 或者是放入的元素要实现Comparable接口后元素自己实现compareTo方法，contains方法是根据比较器或者compareTo去判断相等
* */
public class Point {
    private int x;
    private int y;
    private String desc;

    public Point(int x, int y, String desc) {
        this.x = x;
        this.y = y;
        this.desc = desc;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", desc='" + desc + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
