package com.twu.refactoring;

import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.String.format;

public class Customer {
	private static final String HEADER_LINE = "Rental Record for %s\n";
	private static final String TOTAL_CHARGE_LINE = "Amount owed is %s\n";
	private static final String TOTAL_POINTS_LINE = "You earned %s frequent renter points";
	private static final String EACH_RENTAL_RECORD_LINE = "\t%s\t%s\n";

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		StringBuilder result = new StringBuilder(format(HEADER_LINE, getName()));
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		for (Rental rental : rentalList) {
			totalAmount += rental.getCharge();
			frequentRenterPoints += rental.getFrequentRenterPoints();
			result.append(format(EACH_RENTAL_RECORD_LINE, rental.getMovie().getTitle(), rental.getCharge()));
		}

		result.append(format(TOTAL_CHARGE_LINE, String.valueOf(totalAmount)));
		result.append(format(TOTAL_POINTS_LINE, String.valueOf(frequentRenterPoints)));
		return result.toString();
	}

}
