package com.gridnine.testing.constants;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Constant {

    public final static Segment segment1 = new Segment(
            LocalDateTime.of(2023, 11, 22, 12, 00),
            LocalDateTime.of(2023, 11, 22, 14, 30));

    public final static Segment segment2 = new Segment(
            LocalDateTime.of(2023, 9, 15, 8, 30),
            LocalDateTime.of(2023, 9, 16, 1, 0)
    );

    public final static Segment segment3 = new Segment(
            LocalDateTime.of(2023, 9, 17, 14, 45),
            LocalDateTime.of(2023, 9, 17, 17, 30)
    );

    public final static Segment segment4 = new Segment(
            LocalDateTime.of(2022, 10, 25, 9, 15),
            LocalDateTime.of(2022, 10, 25, 12, 30)
    );

    public final static Segment segment5 = new Segment(
            LocalDateTime.of(2022, 12, 1, 18, 0),
            LocalDateTime.of(2022, 12, 1, 22, 30)
    );

    public final static Flight flights1_2 = FlightBuilder.createFlightFromSegments(segment1, segment2);
    public final static Flight flights2_1 = FlightBuilder.createFlightFromSegments(segment2, segment1);
    public final static Flight flights2_3 = FlightBuilder.createFlightFromSegments(segment2, segment3);
    public final static Flight flights3_2 = FlightBuilder.createFlightFromSegments(segment1, segment2);
    public final static Flight flights1_2_3 = FlightBuilder.createFlightFromSegments(segment1, segment2, segment3);
    public final static Flight flights4_5_3 = FlightBuilder.createFlightFromSegments(segment4, segment5, segment3);

}
