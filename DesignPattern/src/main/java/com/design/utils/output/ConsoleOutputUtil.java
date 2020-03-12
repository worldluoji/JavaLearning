package com.design.utils.output;

public class ConsoleOutputUtil implements OutputUtil {
    @Override
    public void output(String msg,  String topic) {
        if (topic == null || topic.isEmpty()) {
            System.out.println(msg);
        }
        System.out.println(topic + ":" + msg);
    }
}
