package com.design.strategy;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
* 略模式包含一组可选策略，可能客户端要在运行时动态确定使用哪种策略，这也是策略模式最典型的应用场景。
 * 这里的“运行时动态”指的是，我们事先并不知道会使用哪个策略，
 * 而是在程序运行期间，根据配置、用户输入、计算结果等这些不确定因素，动态决定使用哪种策略。
 *  策略有状态，那么就需要使用反射机制去做，这种情况比较少
* */
public class ReflectionFactory {
    private static Map<String, Class<?>> strategyMap = new HashMap<>();
    static {
        strategyMap.put("attack", AttackStrategy.class);
        strategyMap.put("defend", DefendStrategy.class);
    }
    private ReflectionFactory() {

    }
    public static Strategy getStrategy(String type) {
        if (StringUtils.isEmpty(type)) {
            throw new IllegalArgumentException("type不能为空...");
        }
        return getStrategy(strategyMap.get(type));
    }
    public static Strategy getStrategy(Class<?> clazz) {
        if (!Strategy.class.isAssignableFrom(clazz)) {
            throw new IllegalArgumentException("入参不是对应策略的实现");
        }
        Strategy strategy = null;
        try {
            strategy = (Strategy) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return strategy;
    }
}
