package com.gridnine.testing;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Flight>testFlight=FlightBuilder.createFlights();
        FlightFilter flightFilter= new FlightFilter();
        System.out.println(flightFilter.pastFlights(testFlight));
        System.out.println(flightFilter.outDateFlights(testFlight));
        System.out.println(flightFilter.overWait(testFlight,2));
    }
}
