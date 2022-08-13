package com.twa.flights.common.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.Test;

public abstract class FlightsDTOAbstractTest<T> {

    @Test
    protected void settersAndGettersOk() {
        T objectToCheck = buildObjectWithSetters();
        assertAttributes(objectToCheck);
    }

    @Test
    protected void equalsOk() {
        T anObject = buildObjectWithSetters();
        T anotherObject = buildObjectWithSetters();

        assertNotSame(anObject, anotherObject);
        assertEquals(anObject, anotherObject);
    }

    @Test
    protected void notEqualsOk() {
        T anObject = buildObjectWithSetters();
        T notEqualsObject = buildNotEqualsObject();

        assertNotEquals(anObject, notEqualsObject);
    }

    @Test
    protected void hashCodeOk() {
        T anObject = buildObjectWithSetters();
        T anotherObject = buildObjectWithSetters();

        assertEquals(anObject.hashCode(), anotherObject.hashCode());
    }

    @Test
    public void toStringOk() {
        assertEquals(expectedToString(), buildObjectWithSetters().toString());
    }

    protected abstract T buildObjectWithSetters();

    protected abstract T buildNotEqualsObject();

    protected abstract void assertAttributes(T objectToCheck);

    protected abstract String expectedToString();
}
