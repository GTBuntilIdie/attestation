package com.gridnine.testing.ffilter;

import com.gridnine.testing.model.Flight;

import java.util.List;

public interface FlightFilter {
    List<Flight> filterFlights(List<Flight> flights);
}
