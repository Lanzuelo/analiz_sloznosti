package ru.practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SecondTaskTest {

    @Test
    void baseCase() {
        assertEquals(9, SecondTask.gcd(9, 0));
    }

    @Test
    void gcdOf12And8() {
        assertEquals(4, SecondTask.gcd(12, 8));
    }

    @Test
    void gcdOf17And5() {
        assertEquals(1, SecondTask.gcd(17, 5));
    }

    @Test
    void gcdOf21And7() {
        assertEquals(7, SecondTask.gcd(21, 7));
    }

    @Test
    void invalidFirstNumberCausesError() {
        assertThrows(IllegalArgumentException.class,
                () -> SecondTask.gcd(0, 5));
    }

    @Test
    void invalidSecondNumberCausesError() {
        assertThrows(IllegalArgumentException.class,
                () -> SecondTask.gcd(5, -1));
    }
}
