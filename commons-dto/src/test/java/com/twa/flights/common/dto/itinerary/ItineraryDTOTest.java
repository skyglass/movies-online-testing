package com.twa.flights.common.dto.itinerary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.twa.flights.common.dto.FlightsDTOAbstractTest;
import com.twa.flights.common.dto.enums.FlightType;
import com.twa.flights.common.dto.enums.Provider;

public class ItineraryDTOTest extends FlightsDTOAbstractTest<ItineraryDTO> {

    private static final String ID = "be869618-ca1c-4933-94d7-4af1208f1ee2";
    private static final List<SegmentDTO> SEGMENTS = Collections.emptyList();
    private static final PriceInfoDTO PRICE_INFO = new PriceInfoDTO();
    private static final Provider PROVIDER = Provider.ALPHA;
    private static final FlightType FLIGHT_TYPE = FlightType.ROUND_TRIP;
    private static final String CARRIER = "AR";

    @Test
    public void constructorFromAttributesOk() {
        ItineraryDTO itineraryToCheck = new ItineraryDTO(SEGMENTS, PRICE_INFO, PROVIDER, FLIGHT_TYPE, ID, CARRIER);

        assertAttributes(itineraryToCheck);

        // Checking references
        assertNotSame(PRICE_INFO, itineraryToCheck.getPriceInfo());
    }

    @Test
    public void constructorFromDTOOk() {
        ItineraryDTO itineraryDTO = buildObjectWithSetters();

        ItineraryDTO itineraryToCheck = new ItineraryDTO(itineraryDTO);
        assertAttributes(itineraryToCheck);

        // Checking references
        assertNotSame(PRICE_INFO, itineraryToCheck.getPriceInfo());
        assertNotSame(SEGMENTS, itineraryToCheck.getSegments());
    }

    @Override
    public ItineraryDTO buildObjectWithSetters() {
        ItineraryDTO itineraryDTO = new ItineraryDTO();
        itineraryDTO.setId(ID);
        itineraryDTO.setSegments(SEGMENTS);
        itineraryDTO.setPriceInfo(PRICE_INFO);
        itineraryDTO.setFlightType(FLIGHT_TYPE);
        itineraryDTO.setProvider(PROVIDER);
        itineraryDTO.setCarrier(CARRIER);
        return itineraryDTO;
    }

    @Override
    public ItineraryDTO buildNotEqualsObject() {
        final List<SegmentDTO> anotherSegmentList = Collections.singletonList(new SegmentDTO());
        final PriceInfoDTO anotherPriceInfo = new PriceInfoDTO();
        return new ItineraryDTO(anotherSegmentList, anotherPriceInfo, Provider.BETA, FlightType.ONE_WAY, ID + "2",
                CARRIER);
    }

    @Override
    public void assertAttributes(ItineraryDTO objectToCheck) {
        assertEquals(ID, objectToCheck.getId());
        assertEquals(SEGMENTS, objectToCheck.getSegments());
        assertEquals(PRICE_INFO, objectToCheck.getPriceInfo());
        assertEquals(PROVIDER, objectToCheck.getProvider());
        assertEquals(FLIGHT_TYPE, objectToCheck.getFlightType());
        assertEquals(CARRIER, objectToCheck.getCarrier());
    }

    @Override
    public String expectedToString() {
        return "ItineraryDTO{" + "segments=" + SEGMENTS + ", priceInfo=" + PRICE_INFO + ", provider='" + PROVIDER + '\''
                + ", flightType=" + FLIGHT_TYPE + ", id=" + ID + ", carrier=" + CARRIER + '}';
    }
}
