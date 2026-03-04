package com.taxi.service;

import com.taxi.model.Booking;
import com.taxi.model.Taxi;

import java.util.ArrayList;
import java.util.List;

public class TaxiService {

    private List<Taxi> taxis;

    public TaxiService(int taxiCount) {
        taxis = new ArrayList<>();
        for (int i = 1; i <= taxiCount; i++) {
            taxis.add(new Taxi(i));
        }
    }

    public void bookTaxi(int customerId, char from, char to, int pickupTime) {

        Taxi allocatedTaxi = null;
        int minDistance = Integer.MAX_VALUE;

        for (Taxi taxi : taxis) {

            if (taxi.isFree(pickupTime)) {

                int distance = Math.abs(taxi.getCurrentLocation() - from);

                if (allocatedTaxi == null ||
                        distance < minDistance ||
                        (distance == minDistance &&
                                taxi.getTotalEarnings() < allocatedTaxi.getTotalEarnings())) {

                    allocatedTaxi = taxi;
                    minDistance = distance;
                }
            }
        }

        if (allocatedTaxi == null) {
            System.out.println("Booking Rejected. No Taxi Available.");
            return;
        }

        int travelPoints = Math.abs(to - from);
        int dropTime = pickupTime + travelPoints;
        int distanceInKm = travelPoints * 15;

        int amount = calculateFare(distanceInKm);

        Booking booking = new Booking(customerId, from, to,
                pickupTime, dropTime, amount);

        allocatedTaxi.assignBooking(booking);

        System.out.println("Taxi can be allotted.");
        System.out.println("Taxi-" + allocatedTaxi.getTaxiId() + " is allotted.");
    }

    private int calculateFare(int distance) {
        if (distance <= 5)
            return 100;
        return 100 + (distance - 5) * 10;
    }

    public void displayTaxiDetails() {

        for (Taxi taxi : taxis) {

            System.out.println("\nTaxi-" + taxi.getTaxiId()
                    + "    Total Earnings: Rs. " + taxi.getTotalEarnings());

            System.out.println("BookingID  CustomerID  From  To  Pickup  Drop  Amount");

            for (Booking b : taxi.getBookings()) {
                System.out.println(
                        b.getBookingId() + "          " +
                                b.getCustomerId() + "           " +
                                b.getFrom() + "     " +
                                b.getTo() + "   " +
                                b.getPickupTime() + "      " +
                                b.getDropTime() + "    " +
                                b.getAmount()
                );
            }
        }
    }
}