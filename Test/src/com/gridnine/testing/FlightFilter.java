package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class FlightFilter implements Options {


    @Override
    public List<Flight> pastFlights(List<Flight>flights){
        List<Flight> pastFlights= new ArrayList<>();
        for (int i = 0; i <flights.size() ; i++) {
            if(flights.get(i).getSegments().get(0).getDepartureDate().compareTo(LocalDateTime.now())<0){
                pastFlights.add(flights.get(i));
            }
        }
        return pastFlights;
    }
    @Override
    public List<Flight> outDateFlights(List<Flight>flights) {
        List<Flight> outDateFlights = new ArrayList<>();
        for (int i = 0; i < flights.size(); i++) {
            for (int j = 0; j < flights.get(i).getSegments().size(); j++) {
                if (flights.get(i).getSegments().get(0).getDepartureDate().compareTo(flights.get(i).getSegments().get(j).getArrivalDate())<0) {
                    outDateFlights.add(flights.get(i));
                }
            }
        }
        return outDateFlights;
    }
    @Override
    public List<Flight> overWait(List<Flight>flights,int hours) {
        long waitTime = 0;
        List<Flight> overWait = new ArrayList<>();
        for (int i = 0; i < flights.size(); i++) {
            for (int j = 0; j < flights.get(i).getSegments().size()-1; j++) {
                waitTime += ChronoUnit.SECONDS.between(flights.get(i).getSegments().get(j).getArrivalDate(), flights.get(i).getSegments().get(j + 1).getDepartureDate());
            }
            waitTime /= 3600;
            if (waitTime >= hours) {
                overWait.add(flights.get(i));
            }
        }
        return overWait;
    }
}
