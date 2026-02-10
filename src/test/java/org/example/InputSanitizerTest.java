package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InputSanitizerTest {

    @Test
    void parseIntRejectsNonNumber() {
        Result<Integer> r = InputSanitizer.parseInt("ciao", "Scelta");
        assertFalse(r.isOk());
        assertNotNull(r.getUserMessage());
    }

    @Test
    void parseIntAcceptsNumberWithSpaces() {
        Result<Integer> r = InputSanitizer.parseInt("  7 ", "Scelta");
        assertTrue(r.isOk());
        assertEquals(7, (int) r.getValue());
    }
}
