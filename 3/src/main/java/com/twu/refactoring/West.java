package com.twu.refactoring;

public class West extends DirectionBase {
    @Override
    public Direction turnRight() {
        return new Direction('S');
    }

    @Override
    public Direction turnLeft() {
        return new Direction('S');
    }
}
