package com.lambda.apple;

@FunctionalInterface
public interface Predicate<T> {
    boolean select(T t);
}
