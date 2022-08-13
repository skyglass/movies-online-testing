package com.twa.flights.common.dto.request;

import java.util.Objects;

public class AvailabilityRequestDTO {

    private String from;
    private String to;
    private String departure;
    private Integer adults = 1;
    private Integer children = 0;
    private Integer infants = 0;
    private Integer amount;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public Integer getAdults() {
        return adults;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public Integer getInfants() {
        return infants;
    }

    public void setInfants(Integer infants) {
        this.infants = infants;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AvailabilityRequestDTO that = (AvailabilityRequestDTO) o;
        return Objects.equals(from, that.from) && Objects.equals(to, that.to)
                && Objects.equals(departure, that.departure) && Objects.equals(adults, that.adults)
                && Objects.equals(children, that.children) && Objects.equals(infants, that.infants)
                && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, departure, adults, children, infants, amount);
    }

    @Override
    public String toString() {
        return "AvailabilityRequestDTO{" + "from='" + from + '\'' + ", to='" + to + '\'' + ", departure='" + departure
                + '\'' + ", adults=" + adults + ", children=" + children + ", infants=" + infants + ", amount=" + amount
                + '}';
    }
}
