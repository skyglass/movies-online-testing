package com.twa.flights.common.dto.itinerary;

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PriceInfoDTO {

    private PaxPriceDTO adults;
    private PaxPriceDTO children;
    private PaxPriceDTO infants;

    public PriceInfoDTO() {

    }

    public PriceInfoDTO(PriceInfoDTO priceInfoDTO) {
        this(priceInfoDTO.getAdults(), priceInfoDTO.getChildren(), priceInfoDTO.getInfants());
    }

    public PriceInfoDTO(PaxPriceDTO adults, PaxPriceDTO children, PaxPriceDTO infants) {
        this.adults = Objects.nonNull(adults) ? replicatePaxPriceDTO(adults) : null;
        this.children = Objects.nonNull(children) ? replicatePaxPriceDTO(children) : null;
        this.infants = Objects.nonNull(infants) ? replicatePaxPriceDTO(infants) : null;
    }

    private PaxPriceDTO replicatePaxPriceDTO(PaxPriceDTO toReplicate) {
        return new PaxPriceDTO(toReplicate.getTax(), toReplicate.getBase(), toReplicate.getQuantity(),
                toReplicate.getTotal(), toReplicate.getType(), toReplicate.getMarkup(), toReplicate.getSubtotal());
    }

    public PaxPriceDTO getAdults() {
        return adults;
    }

    public void setAdults(PaxPriceDTO adults) {
        this.adults = adults;
    }

    public PaxPriceDTO getChildren() {
        return children;
    }

    public void setChildren(PaxPriceDTO children) {
        this.children = children;
    }

    public PaxPriceDTO getInfants() {
        return infants;
    }

    public void setInfants(PaxPriceDTO infants) {
        this.infants = infants;
    }

    @JsonIgnore
    public BigDecimal getTotalAmount() {

        BigDecimal amount = BigDecimal.ZERO;

        if (Objects.nonNull(this.getAdults())) {
            amount = amount.add(this.getAdults().getTotal());
        }

        if (Objects.nonNull(this.getChildren())) {
            amount = amount.add(this.getChildren().getTotal());
        }

        if (Objects.nonNull(this.getInfants())) {
            amount = amount.add(this.getInfants().getTotal());
        }

        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PriceInfoDTO that = (PriceInfoDTO) o;
        return Objects.equals(adults, that.adults) && Objects.equals(children, that.children)
                && Objects.equals(infants, that.infants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adults, children, infants);
    }

    @Override
    public String toString() {
        return "PriceInfoDTO{" + "adults=" + adults + ", children=" + children + ", infants=" + infants + '}';
    }

}
