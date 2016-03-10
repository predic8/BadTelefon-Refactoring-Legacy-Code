package de.oio.refactoring.badtelefon;

import de.oio.refactoring.badtelefon.output.ConsoleOutputter;
import de.oio.refactoring.badtelefon.output.Outputter;

public class Kunde {
	double gebuehr = 0.0;
	Tarif tarif;
	private Outputter outputter = new ConsoleOutputter();

	private Kunde(int tarifArt) {
		this.tarif = new Tarif(tarifArt);
	}

	public Kunde(int tarifArt, Outputter outputter) {
		this(tarifArt);
		this.outputter = outputter;
	}

	
	public void account(int minuten, int stunde, int minute) {
		String message1 = String.format("Berechne Gespräch mit %02d min um %02d:%02d mit Tarif %s", minuten, stunde, minute, tarif.tarif);
		outputter.writeLine(message1);
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
		String message2 = String.format("Preis für das Gespräch: %.2f", preis);
		outputter.writeLine(message2);
		
		gebuehr += preis;
		String message3 = String.format("Gesamtgebühr nach Gespräch um %02d:%02d (Mondscheinzeit: %s): %.2f", stunde, minute, mondschein, gebuehr);
		outputter.writeLine(message3);
	}

	protected static boolean isMondschein(int stunde) {
		boolean mondschein = false;
		// Mondscheinzeit ?
		if (stunde < 9 || stunde > 18)
			mondschein = true;
		return mondschein;
	}

	public double getGebuehr() {
		return gebuehr;
	}
}
