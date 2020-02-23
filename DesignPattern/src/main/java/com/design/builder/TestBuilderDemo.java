package com.design.builder;

public class TestBuilderDemo {
    public static void main(String[] args) {
        PoolConfig config = new PoolConfig.Builder()
                .name("Test-Pool-1")
                .maxIdle(4)
                .minIdle(2)
                .maxTotal(8)
                .build();
        System.out.println(config);
    }
}
