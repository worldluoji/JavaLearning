package com.equalsandhashcode.treeset;

import com.equalsandhashcode.Point;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetCompareDemo {
    public static void main(String[] args) {
        Set<Point> pointSet = new TreeSet<>((o1,o2) -> {
            Point p1 = (Point)o1;
            Point p2 = (Point)o2;
            if (p1.getX() != p2.getX()) {
                return p1.getX() - p2.getX();
            }
            if (p1.getY() != p2.getY()) {
                return p1.getY() - p2.getY();
            }
            return 0;
        });
        pointSet.add(new Point(1,2,"test1"));
        pointSet.add(new Point(1,3,"test2"));
        pointSet.add(new Point(0,1,"test3"));
        Iterator<Point> it = pointSet.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
