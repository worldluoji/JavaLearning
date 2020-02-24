package com.design.bridge.notification;

import com.design.bridge.msgsender.MsgSender;

import java.util.ArrayList;
import java.util.List;

public abstract class Notification {
    protected List<MsgSender> msgSenders;
    public Notification(MsgSender msgSender) {
        msgSenders = new ArrayList<>();
        msgSenders.add(msgSender);
    }
    public Notification(List<MsgSender> msgSenders) {
        this.msgSenders = msgSenders;
    }
    public abstract void notify(String msg);
}
