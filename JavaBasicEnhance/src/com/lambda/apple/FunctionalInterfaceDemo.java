package com.lambda.apple;

import java.util.UUID;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        Supplier<String> stringSupplier = () -> "hello world " + UUID.randomUUID().toString();
        System.out.println(stringSupplier.get());

        Predicate<Integer> positiveNumber = i -> i > 0;
        System.out.println(positiveNumber.select(-1));

        Function<String, String> duplicate = s -> s.concat(s);
        System.out.println(duplicate.apply("123"));

        BinaryOperator<Integer> subtraction = (a, b) -> a - b;
        System.out.println(subtraction.apply(3,2));

        Consumer<String> println = System.out::println;
        println.accept("hello pikachu");


    }
}
