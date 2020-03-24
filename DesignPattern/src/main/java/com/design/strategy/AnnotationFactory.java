package com.design.strategy;

import com.design.utils.serviceloader.GeneralServiceLoader;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
* 这样，如果新增了一种type, 只需要在新增type的实现类上加上注解即可
* */
public class AnnotationFactory {
    private final static GeneralServiceLoader loader = new GeneralServiceLoader(Strategy.class);
    private AnnotationFactory() {

    }
    private final static Map<String, Strategy> strategyMap = new HashMap<>();
    static {
        Iterator<?> it = loader.loadAll();
        while (it.hasNext()) {
            Strategy strategy = (Strategy)it.next();
            MyStrategy annotation = strategy.getClass().getDeclaredAnnotation(MyStrategy.class);
            strategyMap.putIfAbsent(annotation.type(), strategy);
        }
    }

    public static Strategy getStrategy(String type) {
        if (StringUtils.isEmpty(type)) {
            throw new IllegalArgumentException("type不能为空...");
        }
        return strategyMap.get(type);
    }
}
