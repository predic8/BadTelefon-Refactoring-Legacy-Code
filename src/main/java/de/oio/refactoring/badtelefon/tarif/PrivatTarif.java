package de.oio.refactoring.badtelefon.tarif;

import de.oio.refactoring.badtelefon.*;

public class PrivatTarif extends ZeitabhängigerTarif {

    public static final int FREI_MINUTEN = 1;

    @Override
    protected double gesprächspreisErmitteln(int dauer, Uhrzeit zeit) {
        return preisZurAktuellenZeit(Utils.mindestensNull(dauerNachAbzugDerFreiminuten(dauer)), zeit);
    }

    private int dauerNachAbzugDerFreiminuten(int dauer) {
        return dauer - FREI_MINUTEN;
    }

    @Override
    protected double getPreisMondschein() {
        return 0.69;
    }

    @Override
    protected double getNormalePreis() {
        return  1.99;
    }
}
