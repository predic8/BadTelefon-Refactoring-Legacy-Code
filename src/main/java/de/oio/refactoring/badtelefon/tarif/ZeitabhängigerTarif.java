package de.oio.refactoring.badtelefon.tarif;

import de.oio.refactoring.badtelefon.*;

public abstract class ZeitabhängigerTarif extends Tarif {

    protected double preisZurAktuellenZeit(int dauer, Uhrzeit zeit) {
        if (zeit.isMondschein())
            return dauer * getPreisMondschein();
        else
            return dauer * getNormalePreis();
    }

    protected abstract double getPreisMondschein();

    protected abstract double getNormalePreis();
}
