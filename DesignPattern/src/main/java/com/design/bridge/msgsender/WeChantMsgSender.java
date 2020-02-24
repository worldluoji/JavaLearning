package com.design.bridge.msgsender;

import java.util.List;
import java.util.stream.Stream;

public class WeChantMsgSender implements MsgSender {
    private List<String> weChatIds;
    public WeChantMsgSender(List<String> weChatIds) {
        if (weChatIds == null || weChatIds.isEmpty()) {
            throw new IllegalArgumentException("接收人不能为空！！！");
        }
        this.weChatIds = weChatIds;
    }
    @Override
    public void send(String msg) {
        System.out.println("发送给用户微信：");
        Stream.of(weChatIds).forEach(p -> System.out.println(p));
        System.out.println("内容：" + msg);
    }
}
