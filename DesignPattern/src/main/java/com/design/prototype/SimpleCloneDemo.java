package com.design.prototype;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
* 这里使用java的clone赋值对象，效率会比new出来更好
* */
public class SimpleCloneDemo {
    private final static int MAX_NUM = 100;

    public static void print(List<Student> students) {
        if (students == null || students.isEmpty()) {
            return;
        }
        students.forEach(System.out::println);
    }

    public static void test1() {
        List<Student> students = new ArrayList<>();
        for(int i = 0 ; i < MAX_NUM; i++) {
            Student s = new Student(20+i, "皮卡丘"+i, "成都"+i);
            students.add(s);
        }
        print(students);
    }

    //  测试结果快了50%
    public static void test2() throws CloneNotSupportedException {
        List<Student> students = new ArrayList<>();
        Student s = new Student(20, "皮卡丘0", "成都0");
        students.add(s);
        for(int i = 1 ; i < MAX_NUM; i++) {
            Student newStudent = s.clone();
            newStudent.setId((long)i);
            newStudent.setAge(20+i);
            newStudent.setName("皮卡丘" + i);
            students.add(newStudent);
        }
        print(students);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        LocalDateTime start = LocalDateTime.now();
        //test1();
        test2();
        LocalDateTime end = LocalDateTime.now();
        Duration duration = Duration.between(start, end);
        System.out.println(duration.getNano());
    }
}
