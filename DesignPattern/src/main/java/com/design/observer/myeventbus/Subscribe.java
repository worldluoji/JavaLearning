package com.design.observer.myeventbus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
*   //此注解类型的信息只会记录在源文件中，编译时将被编译器丢弃，也就是说
 *   //不会保存在编译好的类信息中
 *   SOURCE,
 *   //编译器将注解记录在类文件中，但不会加载到JVM中。如果一个注解声明没指定范围，则系统
 *   //默认值就是Class
 *   CLASS,
 *   //注解信息会保留在源文件、类文件中，在执行的时也加载到Java的JVM中，因此可以反射性的读取。
 *   RUNTIME
* */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscribe {
}
