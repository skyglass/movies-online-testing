package com.twa.flights.common.dto.itinerary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.twa.flights.common.dto.FlightsDTOAbstractTest;

public class SegmentDTOTest extends FlightsDTOAbstractTest<SegmentDTO> {

    private static final List<LegDTO> LEGS = Arrays.asList(buildLeg("BUE", "ROM"), buildLeg("ROM", "BUE"));
    private static final String FLIGHT_DURATION = "14:00";

    @Test
    public void constructorFromDTOOk() {
        SegmentDTO segmentDTO = buildObjectWithSetters();
        SegmentDTO objectToCheck = new SegmentDTO(segmentDTO);

        assertAttributes(objectToCheck);
        assertReferences(objectToCheck);
    }

    @Test
    public void constructorFromAttributesOk() {
        SegmentDTO segmentDTO = new SegmentDTO(LEGS, FLIGHT_DURATION);
        assertAttributes(segmentDTO);
    }

    @Test
    public void getFirstLegOk() {
        SegmentDTO segmentDTO = new SegmentDTO();
        segmentDTO.setLegs(LEGS);

        assertEquals("BUE", segmentDTO.firstLeg().getOrigin());
    }

    @Test
    public void getFirstLegWhenLegsAreEmpty() {
        SegmentDTO segmentDTO = new SegmentDTO();
        segmentDTO.setLegs(Collections.emptyList());

        assertNull(segmentDTO.firstLeg());
    }

    @Test
    public void getLastLegOk() {
        SegmentDTO segmentDTO = new SegmentDTO();
        segmentDTO.setLegs(LEGS);

        assertEquals("ROM", segmentDTO.lastLeg().getOrigin());
    }

    @Test
    public void getLastLegWhenLegsAreEmpty() {
        SegmentDTO segmentDTO = new SegmentDTO();
        segmentDTO.setLegs(Collections.emptyList());

        assertNull(segmentDTO.lastLeg());
    }

    private void assertReferences(SegmentDTO segmentDTO) {
        assertNotSame(LEGS, segmentDTO.getLegs());
    }

    @Override
    public SegmentDTO buildObjectWithSetters() {
        SegmentDTO segmentDTO = new SegmentDTO();
        segmentDTO.setLegs(LEGS);
        segmentDTO.setFlightDuration(FLIGHT_DURATION);
        return segmentDTO;
    }

    @Override
    public SegmentDTO buildNotEqualsObject() {
        return new SegmentDTO(Collections.emptyList(), "10:00");
    }

    @Override
    public void assertAttributes(SegmentDTO objectToCheck) {
        assertEquals(LEGS, objectToCheck.getLegs());
        assertEquals(FLIGHT_DURATION, objectToCheck.getFlightDuration());
    }

    @Override
    public String expectedToString() {
        return "SegmentDTO{" + "legs=" + LEGS + ", flightDuration='" + FLIGHT_DURATION + '\'' + '}';
    }

    private static LegDTO buildLeg(String origin, String destination) {
        LegDTO legDTO = new LegDTO();
        legDTO.setOrigin(origin);
        legDTO.setDestination(destination);
        return legDTO;
    }
}
