package com.gridnine.testing;

import java.util.List;

public interface Options {
    List<Flight> pastFlights(List<Flight>flights);
    List<Flight> outDateFlights(List<Flight>flights);
    List<Flight> overWait(List<Flight>flights,int hours);
}
