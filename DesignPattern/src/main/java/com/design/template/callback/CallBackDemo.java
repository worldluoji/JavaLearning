package com.design.template.callback;

/**
* 回调可以分为同步回调和异步回调（或者延迟回调）。
 * 同步回调指在函数返回之前执行回调函数；异步回调指的是在函数返回之后执行回调函数。
 * 下面的代码实际上是同步回调的实现方式，在 process() 函数返回之前，执行完回调函数 methodToCallback()。
 * 异步回调则是回调函数还没执行完就先返回, 扔给线程池去做就能实现
 * 从应用场景上来看，同步回调看起来更像模板模式，异步回调看起来更像观察者模式
* */
public class CallBackDemo {
    public static void main(String[] args) {
        BussinessClass b = new BussinessClass();
        // 业务类调用process方法，里面包含我们下面的回调函数
        b.process(new ICallback() {
            @Override
            public void methodToCallback() {
                System.out.println("发送消息成功");
            }
        });
    }
}
