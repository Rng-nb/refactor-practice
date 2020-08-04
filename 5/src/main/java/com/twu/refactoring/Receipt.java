package com.twu.refactoring;

public class Receipt {


    private final Taxi taxi;

    public Receipt(Taxi taxi) {
        this.taxi = taxi;
    }


    public double getTotalCost() {
        return  taxi.getTotalCost();
    }
}
