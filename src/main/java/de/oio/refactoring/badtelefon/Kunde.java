package de.oio.refactoring.badtelefon;

public class Kunde {

    private double gebuehr = 0.0;
    private Tarif tarif;

    public Kunde(Tarif tarif) {
        this.tarif = tarif;
    }

    public void account(int dauer, int stunde, int minute) {
        gebuehr += tarif.gesprächspreisErmitteln(dauer, new Uhrzeit(stunde, minute));
    }

    public double getGebuehr() {
        return gebuehr;
    }
}
