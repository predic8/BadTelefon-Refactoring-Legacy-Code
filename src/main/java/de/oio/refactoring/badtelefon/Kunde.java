package de.oio.refactoring.badtelefon;

public class Kunde {
	double gebuehr = 0.0;
	Tarif tarif;
	
	Outputter outputter = new ConsoleOutputter();

	public Kunde(int tarifArt) {
		this.tarif = new Tarif(tarifArt);
	}

	public void account(int minuten, int stunde, int minute) {
		String message1 = String.format("Berechne Gespräch mit %02d min um %02d:%02d mit Tarif %s", minuten, stunde, minute, tarif.tarif);
		outputter.writeLine(message1);
		double preis = 0;
		// Gespraechspreis ermitteln
		switch (tarif.tarif) {
		case Tarif.PRIVAT:
			minuten = minuten - 1;
			minuten = minuten < 0 ? 0 : minuten;
			if (isMondschein(stunde))
				preis = minuten * 0.69;
			else
				preis = minuten * 1.99;
			break;

		case Tarif.BUSINESS:
			if (isMondschein(stunde))
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
		String message3 = String.format("Gesamtgebühr nach Gespräch um %02d:%02d (Mondscheinzeit: %s): %.2f", stunde, minute, isMondschein(stunde), gebuehr);
		outputter.writeLine(message3);
	}

	protected static boolean isMondschein(int stunde) {
		return stunde < 9 || stunde > 18;
	}

	public double getGebuehr() {
		return gebuehr;
	}
}
