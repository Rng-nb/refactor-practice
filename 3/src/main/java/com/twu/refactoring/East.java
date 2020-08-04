package com.twu.refactoring;

public class East extends DirectionBase {


    @Override
    public Direction turnRight() {
        return new Direction('N');
    }

    @Override
    public Direction turnLeft() {
        return new Direction('N');
    }
}
