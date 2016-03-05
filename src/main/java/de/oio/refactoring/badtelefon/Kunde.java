package de.oio.refactoring.badtelefon;

import de.oio.refactoring.badtelefon.output.ConsoleOutputter;
import de.oio.refactoring.badtelefon.output.Outputter;

public class Kunde {
	double gebuehr = 0.0;
	Tarif tarif;
	private Outputter consoleOutputter;

	public Kunde(int tarifArt) {
		this.tarif = new Tarif(tarifArt);
		this.consoleOutputter = new ConsoleOutputter();
	}

	public void account(int minuten, int stunde, int minute) {
		consoleOutputter.writeLine(String.format("Berechne Gespräch mit %02d min um %02d:%02d mit Tarif %s", minuten, stunde, minute, tarif.tarif));
		double preis = 0;

		boolean mondschein = isMondschein(stunde);

		// Gespraechspreis ermitteln
		switch (tarif.tarif) {
		case Tarif.PRIVAT:
			minuten = minuten - 1;
			minuten = minuten < 0 ? 0 : minuten;
			if (mondschein)
				preis = minuten * 0.69;
			else
				preis = minuten * 1.99;
			break;

		case Tarif.BUSINESS:
			if (mondschein)
				preis = minuten * 0.79;
			else
				preis = minuten * 1.29;
			break;

		case Tarif.PROFI:
			preis = minuten * 0.69;
			break;

		}
		consoleOutputter.writeLine(String.format("Preis für das Gespräch: %.2f", preis));
		
		gebuehr += preis;
		consoleOutputter.writeLine(String.format("Gesamtgebühr nach Gespräch um %02d:%02d (Mondscheinzeit: %s): %.2f", stunde, minute, mondschein, gebuehr));
	}

	protected static boolean isMondschein(int stunde) {
		return stunde < 9 || stunde > 18;
	}

	public double getGebuehr() {
		return gebuehr;
	}
}
