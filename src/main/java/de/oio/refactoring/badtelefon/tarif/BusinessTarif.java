package de.oio.refactoring.badtelefon.tarif;

import de.oio.refactoring.badtelefon.*;

public class BusinessTarif extends ZeitabhängigerTarif {

    @Override
    protected double gesprächspreisErmitteln(int dauer, Uhrzeit zeit) {
        return preisZurAktuellenZeit(dauer, zeit);
    }

    @Override
    protected double getPreisMondschein() {
        return 0.79;
    }

    @Override
    protected double getNormalePreis() {
        return 1.29;
    }
}
