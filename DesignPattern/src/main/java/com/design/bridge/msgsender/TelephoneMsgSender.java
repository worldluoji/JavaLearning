package com.design.bridge.msgsender;

import java.util.List;
import java.util.stream.Stream;

public class TelephoneMsgSender implements MsgSender {
    private List<String> telephones;
    public TelephoneMsgSender(List<String> telephones) {
        if (telephones == null || telephones.isEmpty()) {
            throw new IllegalArgumentException("接收人不能为空！！！");
        }
        this.telephones = telephones;
    }

    @Override
    public void send(String msg) {
        System.out.println("发送给用户手机：");
        Stream.of(telephones).forEach(p -> System.out.println(p));
        System.out.println("内容：" + msg);
    }
}
