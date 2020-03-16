package com.design.template;

public abstract class TemplateClass {
    public final void  unmodifiedMethod() {
        System.out.println("限制，子类不能修改的方法");
        if (templateMethod()) {
            System.out.println("模板方法测试成功");
        } else {
            System.out.println("模板方法测试失败");
        }
    }
    protected abstract boolean templateMethod();
}
