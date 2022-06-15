package com.design.adapter;

/**
* 通过组合的方式进行适配
* */
public class AdapterByCombination implements ITarget {
    private ITarget target;
    public AdapterByCombination(ITarget target) {
        this.target = target;
    }

    /**
    * 不用修改的方法直接调用即可
    * */
    @Override
    public void hello() {
        target.hello();
    }

    @Override
    public void say(String msg) {
        target.say("adapter:" + msg);
    }
}
