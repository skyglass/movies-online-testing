package com.twa.flights.common.dto.itinerary;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.twa.flights.common.dto.enums.FlightType;
import com.twa.flights.common.dto.enums.Provider;

public class ItineraryDTO {
    private String id;
    private List<SegmentDTO> segments;
    private PriceInfoDTO priceInfo;
    private Provider provider;
    private FlightType flightType;
    private String carrier;

    public ItineraryDTO() {

    }

    public ItineraryDTO(List<SegmentDTO> segments, PriceInfoDTO priceInfo, Provider provider, FlightType flightType,
            String id, String carrier) {
        this.segments = segments;
        this.priceInfo = Objects.nonNull(priceInfo) ? new PriceInfoDTO(priceInfo) : null;
        this.provider = provider;
        this.flightType = flightType;
        this.id = id;
        this.carrier = carrier;
    }

    public ItineraryDTO(ItineraryDTO itinerary) {
        this.segments = copySegments(itinerary.segments);
        this.priceInfo = Objects.nonNull(itinerary.priceInfo) ? new PriceInfoDTO(itinerary.priceInfo) : null;
        this.provider = itinerary.provider;
        this.flightType = itinerary.flightType;
        this.id = itinerary.id;
        this.carrier = itinerary.carrier;
    }

    private List<SegmentDTO> copySegments(List<SegmentDTO> segments) {
        return segments.stream().map(SegmentDTO::new).collect(Collectors.toList());
    }

    public List<SegmentDTO> getSegments() {
        return segments;
    }

    public void setSegments(List<SegmentDTO> segments) {
        this.segments = segments;
    }

    public PriceInfoDTO getPriceInfo() {
        return priceInfo;
    }

    public void setPriceInfo(PriceInfoDTO priceInfo) {
        this.priceInfo = priceInfo;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public void setFlightType(FlightType flightType) {
        this.flightType = flightType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    @JsonIgnore
    public SegmentDTO firstSegment() {
        if (!this.getSegments().isEmpty())
            return this.getSegments().get(0);
        else
            return null;
    }

    @JsonIgnore
    public SegmentDTO lastSegment() {
        if (!this.getSegments().isEmpty())
            return this.getSegments().get(this.getSegments().size() - 1);
        else
            return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ItineraryDTO that = (ItineraryDTO) o;
        return Objects.equals(segments, that.segments) && Objects.equals(priceInfo, that.priceInfo)
                && Objects.equals(provider, that.provider) && flightType == that.flightType
                && Objects.equals(carrier, that.carrier) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(segments, priceInfo, provider, flightType, id, carrier);
    }

    @Override
    public String toString() {
        return "ItineraryDTO{" + "segments=" + segments + ", priceInfo=" + priceInfo + ", provider='" + provider + '\''
                + ", flightType=" + flightType + ", id=" + id + ", carrier=" + carrier + '}';
    }
}
