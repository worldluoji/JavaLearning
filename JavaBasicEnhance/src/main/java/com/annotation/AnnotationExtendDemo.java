package com.annotation;

import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class AnnotationExtendDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Teacher teacher = new Teacher("张老师", 19);
        MyAnnotation annotation = Teacher.class.getAnnotation(MyAnnotation.class);
        if (annotation == null) {
            System.out.println("null on class");
        } else {
            System.out.println(annotation.value());
        }
        Method m = Teacher.class.getMethod("say");
        MyAnnotation annotationInMethod = m.getAnnotation(MyAnnotation.class);
        if (annotationInMethod == null) {
            System.out.println("null on method");
        } else {
            System.out.println(annotationInMethod.value());
            m.invoke(teacher);
        }

        System.out.println(Student.class.getMethod("say").getAnnotation(MyAnnotation.class));

        // Spring提供的AnnotatedElementUtils可以解决注解在方法上继承不到的问题
        Set<MyAnnotation> set = AnnotatedElementUtils.findAllMergedAnnotations(Student.class.getMethod("say"), MyAnnotation.class);
        set.forEach(a -> System.out.println(a.value()));
    }
}
