package de.oio.refactoring.badtelefon;

import de.oio.refactoring.badtelefon.tarif.*;
import org.junit.jupiter.api.Test;

import static de.oio.refactoring.badtelefon.Tarif.*;
import static org.junit.jupiter.api.Assertions.*;

class KundeTest {

    Kunde privat = new Kunde(new PrivatTarif());
    Kunde business = new Kunde(new BusinessTarif());
    Kunde profi = new Kunde(new ProfiTarif());

    @Test
    void privatTarif() {
        privat.account(17, 10, 30);
        privat.account(5, 2, 37);
        privat.account(37, 22, 05);
        assertEquals(59.44,privat.getGebuehr());
    }

    @Test
    void businessTarif() {
        business.account(17, 10, 30);
        business.account(5, 2, 37);
        business.account(37, 22, 05);
        assertEquals(55.11,business.getGebuehr());
    }

    @Test
    void profiTarif() {
        profi.account(17, 10, 30);
        profi.account(37, 22, 05);
        assertEquals(37.26,profi.getGebuehr(),0.01);
    }
}