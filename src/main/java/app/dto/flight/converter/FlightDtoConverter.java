package app.dto.flight.converter;

import app.dto.flight.FlightDto;
import app.entities.Flight;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightDtoConverter {
    public FlightDto flightToFlightDto(Flight flight) {
        var result = FlightDto.builder()
                .id(flight.getId())
                .departureDateTime(flight.getDepartureDateTime())
                .arrivalDateTime(flight.getArrivalDateTime())
                .build();
        return result;

    }
}
