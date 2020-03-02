package com.design.adapter;


/**
* 一般来说，适配器模式可以看作一种“补偿模式”，用来补救设计上的缺陷。应用这种模式算是“无奈之举”。
 * 如果在设计初期，我们就能协调规避接口不兼容的问题，那这种模式就没有应用的机会了。
 *
 * 如果 Adaptee 接口并不多，那两种实现方式都可以。
 * 如果 Adaptee 接口很多，而且 Adaptee 和 ITarget 接口定义大部分都相同，那我们推荐使用类适配器，因为 Adaptor 复用父类 Adaptee 的接口，比起对象适配器的实现方式，Adaptor 的代码量要少一些。
 * 如果 Adaptee 接口很多，而且 Adaptee 和 ITarget 接口定义大部分都不相同，那我们推荐使用对象适配器，因为组合结构相对于继承更加灵活。
* */
public class AdapterDemo {
    public static void main(String[] args) {
        ITarget targetByExtend = new AdapterByExtend();
        targetByExtend.say("你好，皮卡丘");
        ITarget targetByCombination =  new AdapterByCombination(new Adaptee());
        targetByCombination.say("你好，喷火龙");
    }
}
