package com.twa.flights.common.dto.itinerary;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SegmentDTO {

    private List<LegDTO> legs;
    private String flightDuration;

    public SegmentDTO() {

    }

    public SegmentDTO(List<LegDTO> legs, String flightDuration) {
        this.legs = legs;
        this.flightDuration = flightDuration;
    }

    public SegmentDTO(SegmentDTO segment) {
        this.legs = copyLegs(segment.legs);
        this.flightDuration = segment.flightDuration;
    }

    public List<LegDTO> getLegs() {
        return legs;
    }

    public void setLegs(List<LegDTO> legs) {
        this.legs = legs;
    }

    public String getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(String flightDuration) {
        this.flightDuration = flightDuration;
    }

    @JsonIgnore
    public LegDTO firstLeg() {
        if (!this.getLegs().isEmpty())
            return this.getLegs().get(0);
        else
            return null;
    }

    @JsonIgnore
    public LegDTO lastLeg() {
        if (!this.getLegs().isEmpty())
            return this.getLegs().get(this.getLegs().size() - 1);
        else
            return null;
    }

    @JsonIgnore
    public String getOrigin() {
        if (!this.legs.isEmpty())
            return this.legs.get(0).getOrigin();
        else
            return null;
    }

    @JsonIgnore
    public String getDestination() {
        if (!this.legs.isEmpty())
            return this.legs.get(this.legs.size() - 1).getDestination();
        else
            return null;
    }

    private List<LegDTO> copyLegs(List<LegDTO> legs) {
        return legs.stream().map(LegDTO::new).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SegmentDTO that = (SegmentDTO) o;
        return Objects.equals(legs, that.legs) && Objects.equals(flightDuration, that.flightDuration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(legs, flightDuration);
    }

    @Override
    public String toString() {
        return "SegmentDTO{" + "legs=" + legs + ", flightDuration='" + flightDuration + '\'' + '}';
    }
}
