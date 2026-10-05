package ru.practice;

import org.junit.jupiter.api.Test;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void factorialOfZero() {
        assertEquals(1, Factorial.factorialLong(0));
        assertEquals(BigInteger.ONE, Factorial.factorialBigInteger(0));
    }

    @Test
    void factorialOfFive() {
        assertEquals(120, Factorial.factorialLong(5));
        assertEquals(BigInteger.valueOf(120), Factorial.factorialBigInteger(5));
    }

    @Test
    void factorialOfTen() {
        assertEquals(3628800, Factorial.factorialLong(10));
        assertEquals(BigInteger.valueOf(3628800), Factorial.factorialBigInteger(10));
    }

    @Test
    void negativeNumberCausesError() {
        assertThrows(IllegalArgumentException.class,
                () -> Factorial.factorialLong(-1));
        assertThrows(IllegalArgumentException.class,
                () -> Factorial.factorialBigInteger(-1));
    }

    @Test
    void longOverflowStartsAt21() {
        assertEquals(BigInteger.valueOf(Factorial.factorialLong(20)),
                Factorial.factorialBigInteger(20));
        assertNotEquals(BigInteger.valueOf(Factorial.factorialLong(21)),
                Factorial.factorialBigInteger(21));
    }
}
