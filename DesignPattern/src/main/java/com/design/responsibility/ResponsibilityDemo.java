package com.design.responsibility;

/**
* 在职责链模式中，多个处理器（也就是刚刚定义中说的“接收对象”）依次处理同一个请求。
 * 一个请求先经过 A 处理器处理，然后再把请求传递给 B 处理器，B 处理器处理完后再传递给 C 处理器.
 * 以此类推，形成一个链条。链条上的每个处理器各自承担各自的处理职责，所以叫作职责链模式。
* */
public class ResponsibilityDemo {
    public static void main(String[] args) {
        WordFilterChain chain = new WordFilterChain();
        chain.addFilter(new DirtyWordFilter());
        chain.addFilter(new SensitiveWordFilter());
        if (!chain.filter("尼玛")) {
            System.out.println("词汇校验不通过，请修改内容");
        } else {
            System.out.println("您的内容已经审批通过");
        }
        System.out.println("********************************");
        if (!chain.filter("好好学习，天天向上")) {
            System.out.println("词汇校验不通过，请修改内容");
        } else {
            System.out.println("您的内容已经审批通过");
        }
    }
}
