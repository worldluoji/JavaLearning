package com.optional;

import com.optional.models.Car;

import java.util.Optional;

public class TestOptionalDemo3 {

    public static Optional<Car> findByName(String name) {
        return Optional.empty();
    }

    public static void main(String[] args) {
        Car car = findByName("carmen").orElse(new Car("golf", Optional.empty()));
        System.out.println(car);
        Optional<Car> car2 = findByName("carmen2");
        if (car2.isPresent()) {
            System.out.println(car2);
        } else {
            System.out.println("**********************");
        }
    }
}
