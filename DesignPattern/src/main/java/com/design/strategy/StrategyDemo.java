package com.design.strategy;

/**
* 翻译成中文就是：定义一族算法类，将每个算法分别封装起来，让它们可以互相替换。
 * 并根据不同的情况选择不容的策略进行后续处理
 * 策略模式可以帮助我们减少大量的if else分支
* */
public class StrategyDemo {
    public static void main(String[] args) {
        Strategy strategy = StrategyFactory.getStrategy("attack");
        if (strategy != null) {
            strategy.strategy();
        }
        strategy = ReflectionFactory.getStrategy("defend");
        if (strategy != null) {
            strategy.strategy();
        }
    }
}
