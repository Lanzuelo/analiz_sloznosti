package ru.practice;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FirstTaskTest {

    @Test
    void emptyArrayHasOneSubset() {
        Set<String> result = generate(new int[]{});

        assertEquals(Set.of("{}"), result);
    }

    @Test
    void oneElementArrayHasTwoSubsets() {
        Set<String> result = generate(new int[]{1});

        assertEquals(Set.of("{}", "{1}"), result);
    }

    @Test
    void threeElementsProduceEightSubsets() {
        Set<String> result = generate(new int[]{1, 2, 3});

        assertEquals(Set.of(
                "{}", "{1}", "{2}", "{3}",
                "{1, 2}", "{1, 3}", "{2, 3}", "{1, 2, 3}"
        ), result);
    }

    @Test
    void repeatedElementsCauseError() {
        int[] values = {1, 1};
        int[] current = new int[values.length];

        assertThrows(IllegalArgumentException.class,
                () -> FirstTask.generateSubsets(values, 0, current, 0));
    }

    @Test
    void nullArrayCausesError() {
        assertThrows(IllegalArgumentException.class,
                () -> FirstTask.generateSubsets(null, 0, new int[0], 0));
    }

    private Set<String> generate(int[] values) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream oldOutput = System.out;

        try {
            System.setOut(new PrintStream(output));
            FirstTask.generateSubsets(values, 0, new int[values.length], 0);
        } finally {
            System.setOut(oldOutput);
        }

        return output.toString().lines().collect(java.util.stream.Collectors.toSet());
    }
}
