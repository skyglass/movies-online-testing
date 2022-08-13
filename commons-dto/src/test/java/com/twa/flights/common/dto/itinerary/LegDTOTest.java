package com.twa.flights.common.dto.itinerary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.twa.flights.common.dto.FlightsDTOAbstractTest;

public class LegDTOTest extends FlightsDTOAbstractTest<LegDTO> {

    private static final String ORIGIN = "BUE";
    private static final String DESTINATION = "NYC";
    private static final String DEPARTURE_DATE = "2020-12-20";
    private static final String DEPARTURE_TIME = "10:00";
    private static final String ARRIVAL_DATE = "2021-01-03";
    private static final String ARRIVAL_TIME = "23:00";
    private static final Integer NUMBER = 1630;
    private static final String FLIGHT_DURATION = "23:00";

    @Test
    public void constructorFromAttributesOk() {
        LegDTO legDTO = new LegDTO(ORIGIN, DESTINATION, DEPARTURE_DATE, DEPARTURE_TIME, ARRIVAL_DATE, ARRIVAL_TIME,
                NUMBER, FLIGHT_DURATION);
        assertAttributes(legDTO);
    }

    @Test
    public void constructorFromDTOOk() {
        LegDTO legDTO = buildObjectWithSetters();
        assertAttributes(new LegDTO(legDTO));
    }

    @Override
    public LegDTO buildObjectWithSetters() {
        LegDTO legDTO = new LegDTO();
        legDTO.setOrigin(ORIGIN);
        legDTO.setDestination(DESTINATION);
        legDTO.setDepartureDate(DEPARTURE_DATE);
        legDTO.setDepartureTime(DEPARTURE_TIME);
        legDTO.setArrivalDate(ARRIVAL_DATE);
        legDTO.setArrivalTime(ARRIVAL_TIME);
        legDTO.setNumber(NUMBER);
        legDTO.setFlightDuration(FLIGHT_DURATION);
        return legDTO;
    }

    @Override
    public LegDTO buildNotEqualsObject() {
        return new LegDTO("COR", "BRC", "2021-02-13", "19:00", "2021-02-13", "22:00", 9334, FLIGHT_DURATION);
    }

    @Override
    public void assertAttributes(LegDTO objectToCheck) {
        assertEquals(ORIGIN, objectToCheck.getOrigin());
        assertEquals(DESTINATION, objectToCheck.getDestination());
        assertEquals(DEPARTURE_DATE, objectToCheck.getDepartureDate());
        assertEquals(DEPARTURE_TIME, objectToCheck.getDepartureTime());
        assertEquals(ARRIVAL_DATE, objectToCheck.getArrivalDate());
        assertEquals(ARRIVAL_TIME, objectToCheck.getArrivalTime());
        assertEquals(NUMBER, objectToCheck.getNumber());
        assertEquals(FLIGHT_DURATION, objectToCheck.getFlightDuration());
    }

    @Override
    public String expectedToString() {
        return "LegDTO{" + "origin='" + ORIGIN + '\'' + ", destination='" + DESTINATION + '\'' + ", departureDate='"
                + DEPARTURE_DATE + '\'' + ", departureTime='" + DEPARTURE_TIME + '\'' + ", arrivalDate='" + ARRIVAL_DATE
                + '\'' + ", arrivalTime='" + ARRIVAL_TIME + '\'' + ", number=" + NUMBER + ", flightDuration="
                + FLIGHT_DURATION + '}';
    }

}
