package com.twa.flights.common.dto.itinerary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.twa.flights.common.dto.FlightsDTOAbstractTest;
import com.twa.flights.common.dto.enums.PassengerType;

public class PriceInfoDTOTest extends FlightsDTOAbstractTest<PriceInfoDTO> {

    private static final PaxPriceDTO ADULTS = buildPaxPriceDTO(30L, PassengerType.ADULT);
    private static final PaxPriceDTO CHILDREN = buildPaxPriceDTO(20L, PassengerType.CHILD);
    private static final PaxPriceDTO INFANTS = buildPaxPriceDTO(10L, PassengerType.INFANT);

    @Test
    public void constructorFromDTOOk() {
        PriceInfoDTO priceInfoDTO = buildObjectWithSetters();
        assertAttributes(new PriceInfoDTO(priceInfoDTO));
    }

    @Test
    public void constructorFromAttributesOk() {
        PriceInfoDTO priceInfoDTO = new PriceInfoDTO(ADULTS, CHILDREN, INFANTS);
        assertAttributes(priceInfoDTO);
    }

    @Test
    public void constructorFromAttributesOkWhenAdultsAreNull() {
        PriceInfoDTO priceInfoDTO = new PriceInfoDTO(null, CHILDREN, INFANTS);

        assertNull(priceInfoDTO.getAdults());
        assertEquals(CHILDREN, priceInfoDTO.getChildren());
        assertEquals(INFANTS, priceInfoDTO.getInfants());
    }

    @Test
    public void constructorFromAttributesOkWhenChildrenAreNull() {
        PriceInfoDTO priceInfoDTO = new PriceInfoDTO(ADULTS, null, INFANTS);

        assertEquals(ADULTS, priceInfoDTO.getAdults());
        assertNull(priceInfoDTO.getChildren());
        assertEquals(INFANTS, priceInfoDTO.getInfants());
    }

    @Test
    public void constructorFromAttributesOkWhenInfantsAreNull() {
        PriceInfoDTO priceInfoDTO = new PriceInfoDTO(ADULTS, CHILDREN, null);

        assertEquals(ADULTS, priceInfoDTO.getAdults());
        assertEquals(CHILDREN, priceInfoDTO.getChildren());
        assertNull(priceInfoDTO.getInfants());
    }

    @Test
    public void replicatePaxPriceOk() {
        PaxPriceDTO paxPriceDTO = buildPaxPriceDTO(50L, PassengerType.ADULT);

        PriceInfoDTO priceInfoToCheck = new PriceInfoDTO(paxPriceDTO, CHILDREN, INFANTS);

        assertEquals(paxPriceDTO, priceInfoToCheck.getAdults());

        // Checking references
        assertNotSame(paxPriceDTO, priceInfoToCheck.getAdults());
    }

    @Test
    public void getTotalAmountOk() {
        BigDecimal expectedAmount = ADULTS.getTotal().add(CHILDREN.getTotal().add(INFANTS.getTotal()));
        PriceInfoDTO priceInfoDTO = new PriceInfoDTO(ADULTS, CHILDREN, INFANTS);

        assertEquals(expectedAmount, priceInfoDTO.getTotalAmount());
    }

    @Test
    public void getTotalAmountWhenPricesAreNull() {
        PriceInfoDTO priceInfoDTO = new PriceInfoDTO(null, null, null);

        assertEquals(BigDecimal.ZERO, priceInfoDTO.getTotalAmount());
    }

    @Override
    public PriceInfoDTO buildObjectWithSetters() {
        PriceInfoDTO priceInfoDTO = new PriceInfoDTO();
        priceInfoDTO.setAdults(ADULTS);
        priceInfoDTO.setChildren(CHILDREN);
        priceInfoDTO.setInfants(INFANTS);
        return priceInfoDTO;
    }

    @Override
    public PriceInfoDTO buildNotEqualsObject() {
        final PaxPriceDTO anotherAdults = buildPaxPriceDTO(300L, PassengerType.ADULT);
        final PaxPriceDTO anotherChildren = buildPaxPriceDTO(200L, PassengerType.CHILD);
        final PaxPriceDTO anotherInfants = buildPaxPriceDTO(100L, PassengerType.INFANT);
        return new PriceInfoDTO(anotherAdults, anotherChildren, anotherInfants);
    }

    @Override
    public void assertAttributes(PriceInfoDTO objectToCheck) {
        assertEquals(ADULTS, objectToCheck.getAdults());
        assertEquals(CHILDREN, objectToCheck.getChildren());
        assertEquals(INFANTS, objectToCheck.getInfants());
    }

    private static PaxPriceDTO buildPaxPriceDTO(Long ptcTotal, PassengerType passengerType) {
        PaxPriceDTO paxPriceDTO = new PaxPriceDTO();
        paxPriceDTO.setTotal(BigDecimal.valueOf(ptcTotal));
        paxPriceDTO.setType(passengerType);
        return paxPriceDTO;
    }

    @Override
    public String expectedToString() {
        return "PriceInfoDTO{" + "adults=" + ADULTS + ", children=" + CHILDREN + ", infants=" + INFANTS + '}';
    }
}
