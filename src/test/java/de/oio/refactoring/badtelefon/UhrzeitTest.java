package de.oio.refactoring.badtelefon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UhrzeitTest {

    Uhrzeit z1 = new Uhrzeit(11, 4);
    Uhrzeit z2 = new Uhrzeit(4, 20);
    Uhrzeit z3 = new Uhrzeit(5, 55);

    @Test
    void keinMondschein() {
        assertFalse(z1.isMondschein());
    }

    @Test
    void mondschein() {
        assertTrue(z2.isMondschein());
        assertTrue(z3.isMondschein());
    }

}