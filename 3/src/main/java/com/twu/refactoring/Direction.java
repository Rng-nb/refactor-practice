package com.twu.refactoring;

public class Direction {
    private final char direction;

    public Direction(char direction) {
        this.direction = direction;

    }

    public Direction turnRight() {
        DirectionBase directionBase = getDirection(direction);
        return  directionBase.turnRight();
    }

    public Direction turnLeft() {
        DirectionBase directionBase = getDirection(direction);
        return  directionBase.turnLeft();
    }

    public DirectionBase getDirection(char direction) {
        switch (direction) {
            case 'N':
                return new North();
            case 'S':
                return new South();
            case 'E':
                return new East();
            case 'W':
                return new West();
            default:
                throw new IllegalArgumentException();
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction1 = (Direction) o;

        if (direction != direction1.direction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) direction;
    }

    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }
}