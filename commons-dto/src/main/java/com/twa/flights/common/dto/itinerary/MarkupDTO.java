package com.twa.flights.common.dto.itinerary;

import java.math.BigDecimal;
import java.util.Objects;

public class MarkupDTO {

    private BigDecimal percentage;

    private BigDecimal amount;

    public MarkupDTO() {

    }

    public MarkupDTO(BigDecimal percentage, BigDecimal amount) {
        this.percentage = percentage;
        this.amount = amount;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MarkupDTO that = (MarkupDTO) o;
        return Objects.equals(percentage, that.percentage) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(percentage, amount);
    }

    @Override
    public String toString() {
        return "MarkupDTO{" + "percentage=" + percentage + ", amount=" + amount + '}';
    }
}
