package ru.practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FirstTaskTest {

    @Test
    void baseCase() {
        assertEquals(3, FirstTask.money(3, 4, 0));
    }

    @Test
    void positiveDifference() {
        assertEquals(15, FirstTask.money(3, 4, 3));
    }

    @Test
    void negativeDifference() {
        assertEquals(4, FirstTask.money(10, -2, 3));
    }

    @Test
    void negativeDayCausesError() {
        assertThrows(IllegalArgumentException.class,
                () -> FirstTask.money(3, 4, -1));
    }
}
