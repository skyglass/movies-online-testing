package com.twa.flights.common.dto.itinerary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.twa.flights.common.dto.FlightsDTOAbstractTest;
import com.twa.flights.common.dto.enums.PassengerType;

public class PaxPriceDTOTest extends FlightsDTOAbstractTest<PaxPriceDTO> {

    private static final BigDecimal TAX = new BigDecimal(2);
    private static final BigDecimal TOTAL = new BigDecimal(4);
    private static final BigDecimal BASE = new BigDecimal(5);
    private static final Integer QUANTITY = 1;
    private static final PassengerType PASSENGER_TYPE = PassengerType.ADULT;
    private static final BigDecimal SUBTOTAL = new BigDecimal(4);
    private static final MarkupDTO MARKUP = new MarkupDTO(BigDecimal.ONE, BigDecimal.ONE);

    @Test
    public void constructorFromAttributesOk() {
        PaxPriceDTO paxPriceDTO = new PaxPriceDTO(TAX, BASE, QUANTITY, TOTAL, PASSENGER_TYPE, MARKUP, SUBTOTAL);
        assertAttributes(paxPriceDTO);
    }

    @Override
    public PaxPriceDTO buildObjectWithSetters() {
        PaxPriceDTO paxPriceDTO = new PaxPriceDTO();
        paxPriceDTO.setTax(TAX);
        paxPriceDTO.setBase(BASE);
        paxPriceDTO.setTotal(TOTAL);
        paxPriceDTO.setQuantity(QUANTITY);
        paxPriceDTO.setType(PASSENGER_TYPE);
        paxPriceDTO.setMarkup(MARKUP);
        paxPriceDTO.setSubtotal(SUBTOTAL);
        return paxPriceDTO;
    }

    @Override
    public PaxPriceDTO buildNotEqualsObject() {
        return new PaxPriceDTO(BigDecimal.ZERO, BigDecimal.ZERO, 3, BigDecimal.ZERO, PassengerType.INFANT, MARKUP,
                SUBTOTAL);
    }

    @Override
    public void assertAttributes(PaxPriceDTO objectToCheck) {
        assertEquals(TAX, objectToCheck.getTax());
        assertEquals(BASE, objectToCheck.getBase());
        assertEquals(TOTAL, objectToCheck.getTotal());
        assertEquals(QUANTITY, objectToCheck.getQuantity());
        assertEquals(PASSENGER_TYPE, objectToCheck.getType());
        assertEquals(MARKUP, objectToCheck.getMarkup());
        assertEquals(SUBTOTAL, objectToCheck.getSubtotal());
    }

    @Override
    public String expectedToString() {
        return "PaxPriceDTO{" + "tax=" + TAX + ", base=" + BASE + ", quantity=" + QUANTITY + ", total=" + TOTAL
                + ", type=" + PASSENGER_TYPE + ", subtotal=" + SUBTOTAL + ", markup=" + MARKUP + "}";
    }
}
