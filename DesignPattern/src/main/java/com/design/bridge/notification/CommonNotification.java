package com.design.bridge.notification;

import com.design.bridge.msgsender.MsgSender;

/**
* 普通通知只需要微信通知即可
* */
public class CommonNotification extends Notification {
    public CommonNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String msg) {
        msgSenders.get(0).send(msg);
    }
}
