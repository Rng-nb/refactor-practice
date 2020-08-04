package com.twu.refactoring;

public class Taxi {
    private static final int FIXED_CHARGE = 50;
    private static final double PEAK_TIME_MULTIPLIER = 1.2;
    private static final double OFF_PEAK_MULTIPLIER = 1.0;
    private static final int RATE_CHANGE_DISTANCE = 10;
    private static final int PRE_RATE_CHANGE_NON_AC_RATE = 15;
    private static final int POST_RATE_CHANGE_NON_AC_RATE = 12;
    private static final int PRE_RATE_CHANGE_AC_RATE = 20;
    private static final int POST_RATE_CHANGE_AC_RATE = 17;
    private static final double SALES_TAX_RATE = 0.1;

    private boolean airConditioned;
    private final int totalKms;
    private final boolean peakTime;

    public Taxi(boolean airConditioned, int totalKms, boolean peakTime) {
        this.airConditioned = airConditioned;
        this.totalKms = totalKms;
        this.peakTime = peakTime;
    }

    public boolean isAirConditioned() {
        return airConditioned;
    }

    public int getTotalKms() {
        return totalKms;
    }

    public boolean isPeakTime() {
        return peakTime;
    }

    public double getTotalCost() {
        double totalCost = 0;
        totalCost += FIXED_CHARGE;

        double peakTimeMultiple = peakTime ? PEAK_TIME_MULTIPLIER : OFF_PEAK_MULTIPLIER;
        int preRate= airConditioned ? PRE_RATE_CHANGE_AC_RATE : PRE_RATE_CHANGE_NON_AC_RATE;
        int postRate = airConditioned ? POST_RATE_CHANGE_AC_RATE : POST_RATE_CHANGE_NON_AC_RATE;

        totalCost += Math.min(RATE_CHANGE_DISTANCE, totalKms) * preRate * peakTimeMultiple;
        totalCost += Math.max(0, totalKms - RATE_CHANGE_DISTANCE) * postRate * peakTimeMultiple;

        return totalCost * (1 + SALES_TAX_RATE);
    }
}
