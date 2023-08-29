package com.gridnine.testing.ffilter;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TimeOnGroundFilter implements FlightFilter {
    // Фильтрует перелёты, у которых общее время, проведённое на земле, превышает два часа.

    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        List<Flight> filterFlights = new ArrayList<>();
        List<Segment> segments = new ArrayList<>();
        for (int i = 0; i < flights.size() - 1 ; i++) {
            if (flights.get(i).getSegments().size() > 1) {
                segments.addAll(flights.get(i).getSegments());


                for (int j = 0; j < segments.size() - 1; j++) {
                 Segment currentSegment = segments.get(j);
                    Segment nextSegment = segments.get(j + 1);

                    LocalDateTime currentDateArrival = currentSegment.getArrivalDate();
                    LocalDateTime nextDateDeparture = nextSegment.getDepartureDate();

                    Duration timeInterval = Duration.between(currentDateArrival, nextDateDeparture);
                    if (timeInterval.toHours() > 2) {
                        filterFlights.add(flights.get(j));
                    }
                }
            }
        }
        return filterFlights;
    }
}