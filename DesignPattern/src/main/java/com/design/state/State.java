package com.design.state;

public enum State {
    SMALL(0),
    SUPER(1),
    FIRE(2),
    CAPE(3);
    private int state;
    State(int state) {
        this.state = state;
    }
    public int value() {
        return this.state;
    }
}
