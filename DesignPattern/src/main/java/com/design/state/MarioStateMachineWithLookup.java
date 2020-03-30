package com.design.state;

import static com.design.state.State.*;

/**
* 查表法解决状态转移问题
 * 实际上，像游戏这种比较复杂的状态机，包含的状态比较多，我优先推荐使用查表法，而状态模式会引入非常多的状态类，会导致代码比较难维护。
 * 相反，像电商下单、外卖下单这种类型的状态机，它们的状态并不多，状态转移也比较简单，但事件触发执行的动作包含的业务逻辑可能会比较复杂，所以，更加推荐使用状态模式来实现。
* */
public class MarioStateMachineWithLookup {
    private int score;
    private State currentState;
    // 第一维度表示当前的状态，第二维表示发生的事件
    private static final State[][] transitionTable = { {SUPER, CAPE, FIRE, SMALL}, {SUPER, CAPE, FIRE, SMALL}, {CAPE, CAPE, CAPE, SMALL}, {FIRE, FIRE, FIRE, SMALL} };
    // 发生事件后的积分动作
    private static final int[][] actionTable = { {+100, +200, +300, +0}, {+0, +200, +300, -100}, {+0, +0, +0, -200}, {+0, +0, +0, -300} };
    public MarioStateMachineWithLookup() {
        this.score = 0;
        this.currentState = SMALL;
    }

    public void executeEvent(Event event) {
        int stateValue = currentState.value();
        int eventValue = event.value();
        this.currentState = transitionTable[stateValue][eventValue];
        this.score = actionTable[stateValue][eventValue];
    }

    public void obtainMushRoom() {
        executeEvent(Event.GOT_MUSHROOM);
    }

    public void obtainCape() {
        executeEvent(Event.GOT_CAPE);
    }

    public void obtainFireFlower() {
        executeEvent(Event.GOT_FIRE);
    }

    public void meetMonster() {
        executeEvent(Event.MET_MONSTER);
    }

    public int getScore() {
        return this.score;
    }

    public State getCurrentState() {
        return this.currentState;
    }
}

