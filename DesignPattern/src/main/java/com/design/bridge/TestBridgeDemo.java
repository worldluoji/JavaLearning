package com.design.bridge;

import com.design.bridge.msgsender.MsgSender;
import com.design.bridge.msgsender.TelephoneMsgSender;
import com.design.bridge.msgsender.WeChantMsgSender;
import com.design.bridge.notification.Notification;
import com.design.bridge.notification.UrgentNotification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* 这个例子中，将发消息MsgSender和通知Notification独立开来，两部份都能自由扩展，组合起来使用
* */
public class TestBridgeDemo {
    public static void main(String[] args) {
        List<MsgSender> senders = new ArrayList<>();
        List<String> weChantIds = Arrays.asList("wolong", "fengchu", "zhonghu");
        List<String> telephones = Arrays.asList("6666666666", "3333333333","8888888888");
        senders.add(new WeChantMsgSender(weChantIds));
        senders.add(new TelephoneMsgSender(telephones));
        Notification notification = new UrgentNotification(senders);
        notification.notify("紧急通知：由于疫情影响，小区封闭，请尽快联系楼栋管家办理通行证");
    }
}
