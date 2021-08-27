package de.oio.refactoring.badtelefon.tarif;

public class Utils {

    public static int mindestensNull(int dauer) {
        return dauer < 0 ? 0 : dauer;
    }

}
