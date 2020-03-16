package com.design.template;


/**
*  模板方法模式在一个方法中定义一个算法骨架，并将某些步骤推迟到子类中实现。
 * 模板方法模式可以让子类在不改变算法整体结构的情况下，重新定义算法中的某些步骤。
 * 这里的“算法”，我们可以理解为广义上的“业务逻辑”，并不特指数据结构和算法中的“算法”。
 * 这里的算法骨架就是“模板”，包含算法骨架的方法就是“模板方法”，这也是模板方法模式名字的由来。
 * 模板模式有两大作用：复用和扩展
 *
 * 比如： InputStream 在代码中，read() 函数是一个模板方法，定义了读取数据的整个流程，并且暴露了一个可以由子类来定制的抽象方法
* */
public class TemplatePatternDemo {
    public static void main(String[] args) {
        TemplateClass cl = new ConcreteClass();
        cl.unmodifiedMethod();
    }
}
