package de.oio.refactoring.badtelefon.tarif;

import de.oio.refactoring.badtelefon.*;

public class ProfiTarif extends Tarif {

    @Override
    protected double gesprächspreisErmitteln(int dauer, Uhrzeit zeit) {
        return dauer * 0.69;
    }
}
