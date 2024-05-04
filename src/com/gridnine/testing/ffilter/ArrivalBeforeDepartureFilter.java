package com.gridnine.testing.ffilter;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ArrivalBeforeDepartureFilter implements FlightFilter {
    // Фильтрует перелёты, у которых имеются сегменты с датой прилёта раньше даты вылета.

    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        List<Flight> filterFlightList = new ArrayList<>();
        for (int i = 0; i < (flights.size() - 1); i++) {
            if (flights.get(i).getSegments().size() == 1) {
                // если сегмент в текущем полете один
                LocalDateTime dep = flights.get(i).getSegments().get(0).getDepartureDate();
                LocalDateTime arr = flights.get(i).getSegments().get(0).getArrivalDate();

                if (dep.isAfter(arr)) {
                    filterFlightList.add(flights.get(i));
                }
        } else {
            // если несколько сегментов
            List<Segment> segmentList = flights.get(i).getSegments();
            for (int j = 0; j < segmentList.size() - 1; j++) {
                LocalDateTime dep = segmentList.get(j).getDepartureDate();
                LocalDateTime arr = segmentList.get(j).getArrivalDate();
                LocalDateTime depNext = segmentList.get(j + 1).getDepartureDate();

                if (dep.isAfter(arr) || arr.isAfter(depNext)) {
                    filterFlightList.add(flights.get(i));
                }
            }
        }
        }
        return filterFlightList;
    }
}

