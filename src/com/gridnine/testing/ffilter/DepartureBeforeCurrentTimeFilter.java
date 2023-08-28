package com.gridnine.testing.ffilter;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DepartureBeforeCurrentTimeFilter implements FlightFilter {
    // Фильтрует перелёты, у которых время вылета раньше текущего времени.

    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        List<Flight> filterFlightsList = new ArrayList<>();
        for (int i = 0; i < flights.size() - 1 ; i++) {
            for (Segment seg : flights.get(i).getSegments()) {
            if (seg.getDepartureDate().isBefore(LocalDateTime.now())) {
                filterFlightsList.add(flights.get(i));}
            }
        }
        return filterFlightsList;
    }
}