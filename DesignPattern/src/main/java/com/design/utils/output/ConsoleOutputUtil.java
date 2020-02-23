package com.design.utils.output;

public class ConsoleOutputUtil implements OutputUtil {
    @Override
    public void output(String msg,  String topic) {
        System.out.println(msg);
    }
}
