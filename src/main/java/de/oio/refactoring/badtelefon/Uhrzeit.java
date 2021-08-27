package de.oio.refactoring.badtelefon;

public class Uhrzeit {

    private int stunde;
    private int minute;

    public Uhrzeit(int stunde, int minute) {
        this.stunde = stunde;
        this.minute = minute;
    }

    public int getStunde() {
        return stunde;
    }

    public int getMinute() {
        return minute;
    }

    /**
     * Mondscheintarif anwendbar?
     */
    public boolean isMondschein() {
        return  stunde < 9 | stunde > 18;
    }
}
