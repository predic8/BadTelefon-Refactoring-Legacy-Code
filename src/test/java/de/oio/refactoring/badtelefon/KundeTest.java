package de.oio.refactoring.badtelefon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.oio.refactoring.badtelefon.output.Outputter;
import de.oio.refactoring.badtelefon.output.StringOutputter;

public class KundeTest {

	@Test
	public void testAccount() {
		Outputter stringOutputter = new StringOutputter();
		Kunde kunde = new Kunde(Tarif.BUSINESS, stringOutputter);
		kunde.account(10, 12, 35);
		assertEquals(
				"Berechne Gespr�ch mit 10 min um 12:35 mit Tarif 1\r\n" + "Preis f�r das Gespr�ch: 12,90\r\n"
						+ "Gesamtgeb�hr nach Gespr�ch um 12:35 (Mondscheinzeit: false): 12,90\r\n",
				stringOutputter.toString());
	}

}
