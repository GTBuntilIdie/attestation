import com.gridnine.testing.ffilter.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.ffilter.DepartureBeforeCurrentTimeFilter;
import com.gridnine.testing.ffilter.FlightFilter;
import com.gridnine.testing.ffilter.TimeOnGroundFilter;
import com.gridnine.testing.model.Flight;

import java.util.ArrayList;
import java.util.List;

import static com.gridnine.testing.constants.Constant.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Flight> flights = new ArrayList<>();
        flights.add(flights1_2);
        flights.add(flights2_3);
        flights.add(flights2_1);
        //flights.add(flights2_3);
        //flights.add(flights3_2);
        //flights.add(flights4_5_3);

        // Создание экземпляров фильтров
        FlightFilter departureBeforeCurrentTimeFilter = new DepartureBeforeCurrentTimeFilter();
        FlightFilter arrivalBeforeDepartureFilter = new ArrivalBeforeDepartureFilter();
        FlightFilter groundTimeExceedsTwoHoursFilter = new TimeOnGroundFilter();

        // Применение фильтров к тестовому набору перелётов
        List<Flight> filteredFlights1 = departureBeforeCurrentTimeFilter.filterFlights(flights);
        List<Flight> filteredFlights2 = arrivalBeforeDepartureFilter.filterFlights(flights);
        List<Flight> filteredFlights3 = groundTimeExceedsTwoHoursFilter.filterFlights(flights);

        // Вывод результатов фильтрации в консоль
        System.out.println("Вылет до текущего момента времени:");
        printFlights(filteredFlights1);

        System.out.println("\nСегменты с датой прилёта раньше даты вылета:");
        printFlights(filteredFlights2);

        System.out.println("\nОбщее время на земле превышает два часа:");
        printFlights(filteredFlights3);
    }

    private static void printFlights(List<Flight> flights) {
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }
}


