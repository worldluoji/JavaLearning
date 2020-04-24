package com.annotation;

import java.lang.annotation.*;


/**
* @Inherited 只有注解在类上才能被继承，注解在方法上不行
* */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MyAnnotation {
    String value();
}
