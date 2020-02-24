package com.design.bridge.notification;

import com.design.bridge.msgsender.MsgSender;

import java.util.List;

/**
* 紧急通知，需要微信和电话同时通知
* */
public class UrgentNotification extends Notification {
    public UrgentNotification(MsgSender msgSender) {
        super(msgSender);
    }

    public UrgentNotification(List<MsgSender> msgSenders) {
        super(msgSenders);
    }

    @Override
    public void notify(String msg) {
        for (MsgSender sender : msgSenders) {
            sender.send(msg);
        }
    }
}
