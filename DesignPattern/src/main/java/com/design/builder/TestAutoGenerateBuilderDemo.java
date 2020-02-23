package com.design.builder;

import com.design.builder.tool.AutoGenerateClassWithBuilder;
import com.design.builder.tool.DefaultAutoGenerateClassWithBuilder;

public class TestAutoGenerateBuilderDemo {
    public static void main(String[] args) {
        AutoGenerateClassWithBuilder tool = new DefaultAutoGenerateClassWithBuilder();
        tool.generate(PoolConfig.class);
    }
}
