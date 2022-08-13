package com.twa.flights.common.dto.itinerary;

import java.math.BigDecimal;
import java.util.Objects;

import com.twa.flights.common.dto.enums.PassengerType;

public class PaxPriceDTO {

    private BigDecimal tax;
    private BigDecimal base;
    private Integer quantity;
    private BigDecimal subtotal;
    private BigDecimal total;
    private PassengerType type;
    private MarkupDTO markup;

    public PaxPriceDTO() {

    }

    public PaxPriceDTO(PaxPriceDTO paxPrice) {
        this.tax = paxPrice.getTax();
        this.base = paxPrice.getBase();
        this.quantity = paxPrice.getQuantity();
        this.subtotal = paxPrice.getSubtotal();
        this.total = paxPrice.getTotal();
        this.type = paxPrice.getType();
        this.markup = paxPrice.getMarkup();
    }

    public PaxPriceDTO(BigDecimal tax, BigDecimal base, Integer quantity, BigDecimal total, PassengerType type,
            MarkupDTO markup, BigDecimal subtotal) {
        this.tax = tax;
        this.base = base;
        this.quantity = quantity;
        this.total = total;
        this.type = type;
        this.markup = markup;
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getBase() {
        return base;
    }

    public void setBase(BigDecimal base) {
        this.base = base;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public PassengerType getType() {
        return type;
    }

    public void setType(PassengerType type) {
        this.type = type;
    }

    public MarkupDTO getMarkup() {
        return markup;
    }

    public void setMarkup(MarkupDTO markup) {
        this.markup = markup;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PaxPriceDTO that = (PaxPriceDTO) o;
        return Objects.equals(tax, that.tax) && Objects.equals(base, that.base)
                && Objects.equals(quantity, that.quantity) && Objects.equals(total, that.total)
                && Objects.equals(subtotal, that.subtotal) && Objects.equals(markup, that.markup)
                && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tax, base, quantity, total, type, markup, subtotal);
    }

    @Override
    public String toString() {
        return "PaxPriceDTO{" + "tax=" + tax + ", base=" + base + ", quantity=" + quantity + ", total=" + total
                + ", type=" + type + ", subtotal=" + subtotal + ", markup=" + markup + '}';
    }
}
