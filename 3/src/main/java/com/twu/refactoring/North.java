package com.twu.refactoring;

public class North extends DirectionBase {
    @Override
    public Direction turnRight() {
        return new Direction('E');
    }

    @Override
    public Direction turnLeft() {
        return new Direction('W');
    }
}

