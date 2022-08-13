package com.twa.flights.common.dto.request;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.twa.flights.common.dto.FlightsDTOAbstractTest;
import com.twa.flights.common.dto.request.AvailabilityRequestDTO;

public class AvailabilityRequestDTOTest extends FlightsDTOAbstractTest<AvailabilityRequestDTO> {

    private static final String FROM = "BUE,BRC";
    private static final String TO = "BRC,BUE";
    private static final String DEPARTURE = "2021-02-10,2021-02-20";
    private static final Integer ADULTS = 2;
    private static final Integer CHILDREN = 1;
    private static final Integer INFANTS = 1;
    private static final Integer AMOUNT = 1;

    @Override
    public AvailabilityRequestDTO buildObjectWithSetters() {
        AvailabilityRequestDTO availabilityRequestDTO = new AvailabilityRequestDTO();
        availabilityRequestDTO.setFrom(FROM);
        availabilityRequestDTO.setTo(TO);
        availabilityRequestDTO.setDeparture(DEPARTURE);
        availabilityRequestDTO.setAdults(ADULTS);
        availabilityRequestDTO.setChildren(CHILDREN);
        availabilityRequestDTO.setInfants(INFANTS);
        availabilityRequestDTO.setAmount(AMOUNT);
        return availabilityRequestDTO;
    }

    @Override
    public AvailabilityRequestDTO buildNotEqualsObject() {
        AvailabilityRequestDTO availabilityRequestDTO = new AvailabilityRequestDTO();
        availabilityRequestDTO.setFrom("FROM");
        availabilityRequestDTO.setTo("TO");
        availabilityRequestDTO.setDeparture("DEPARTURE");
        availabilityRequestDTO.setAdults(3);
        availabilityRequestDTO.setChildren(3);
        availabilityRequestDTO.setInfants(3);
        availabilityRequestDTO.setAmount(9);
        return availabilityRequestDTO;
    }

    @Override
    public void assertAttributes(AvailabilityRequestDTO objectToCheck) {
        assertEquals(FROM, objectToCheck.getFrom());
        assertEquals(TO, objectToCheck.getTo());
        assertEquals(DEPARTURE, objectToCheck.getDeparture());
        assertEquals(ADULTS, objectToCheck.getAdults());
        assertEquals(CHILDREN, objectToCheck.getChildren());
        assertEquals(INFANTS, objectToCheck.getInfants());
        assertEquals(AMOUNT, objectToCheck.getAmount());
    }

    @Override
    public String expectedToString() {
        return "AvailabilityRequestDTO{" + "from='" + FROM + '\'' + ", to='" + TO + '\'' + ", departure='" + DEPARTURE
                + '\'' + ", adults=" + ADULTS + ", children=" + CHILDREN + ", infants=" + INFANTS + ", amount=" + AMOUNT
                + '}';
    }
}
