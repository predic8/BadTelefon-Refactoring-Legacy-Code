package de.oio.refactoring.badtelefon;

public class Kunde {

	private double gebuehr = 0.0;
	private Tarif tarif;
	private boolean mondschein;

	public Kunde(int tarifArt) {
		this.tarif = new Tarif(tarifArt);
	}

	public void account(int minuten, int stunde, int minute) {

		double preis = 0;

		// Mondscheintarif anwendbar?
		if (stunde < 9 | stunde > 18)
			mondschein = true;
		else
			mondschein = false;

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
		
		gebuehr += preis;
	}

	public double getGebuehr() {
		return gebuehr;
	}

}
