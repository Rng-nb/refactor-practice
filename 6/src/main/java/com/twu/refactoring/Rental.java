package com.twu.refactoring;

public class Rental {

    private Movie movie;

    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getCharge() {
        double charge = 0.;
        if(movie.getPriceCode() == Movie.REGULAR) {
            charge = 2;
            if(daysRented > 2)
                charge = (daysRented - 2) * 1.5;
        }
        if(movie.getPriceCode() == Movie.NEW_RELEASE) {
            charge = daysRented * 3;
        }
        if(movie.getPriceCode() == Movie.CHILDRENS) {
            charge = (daysRented - 3) * 1.5;
        }
        return charge;
    }

    public int getFrequentRenterPoints() {
        if(movie.getPriceCode() == Movie.NEW_RELEASE) {
            if(daysRented > 1)
                return 2;
        }
        return 1;
    }

}