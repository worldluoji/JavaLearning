package com.design.strategy;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
* 事先能确定哪些策略的情况下，就可以这样，用一个工厂+一个Map把策略封装进去直接用
* */
public class StrategyFactory {
    private StrategyFactory() {

    }
    private final static Map<String, Strategy> strategyMap = new HashMap<>();
    static {
        strategyMap.put("attack", new AttackStrategy());
        strategyMap.put("defend", new DefendStrategy());
    }

    public static Strategy getStrategy(String type) {
        if (StringUtils.isEmpty(type)) {
            throw new IllegalArgumentException("type不能为空...");
        }
        return strategyMap.get(type);
    }
}
