package com.taxi.model;

import java.util.ArrayList;
import java.util.List;

public class Taxi {

    private int taxiId;
    private char currentLocation;
    private int freeTime;
    private int totalEarnings;
    private List<Booking> bookings;

    public Taxi(int taxiId) {
        this.taxiId = taxiId;
        this.currentLocation = 'A';
        this.freeTime = 0;
        this.totalEarnings = 0;
        this.bookings = new ArrayList<>();
    }

    public int getTaxiId() { return taxiId; }
    public char getCurrentLocation() { return currentLocation; }
    public int getFreeTime() { return freeTime; }
    public int getTotalEarnings() { return totalEarnings; }
    public List<Booking> getBookings() { return bookings; }

    public boolean isFree(int pickupTime) {
        return pickupTime >= freeTime;
    }

    public void assignBooking(Booking booking) {
        bookings.add(booking);
        totalEarnings += booking.getAmount();
        currentLocation = booking.getTo();
        freeTime = booking.getDropTime();
    }
}