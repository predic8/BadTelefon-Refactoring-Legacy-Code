package de.oio.refactoring.badtelefon;

import static org.junit.Assert.assertEquals;
// move above class declaration !!!
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class KundeTests {

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

	private Outputter outputterMock;

	@Before
	public void init() {
		outputterMock = Mockito.mock(Outputter.class);
	}

	@Test
	public void testAccountWithBusinessTarif() {
		new Kunde(Tarif.BUSINESS, outputterMock).account(10, 12, 35);
		verify(outputterMock).writeLine("Berechne Gespr�ch mit 10 min um 12:35 mit Tarif 1");
		verify(outputterMock).writeLine("Preis f�r das Gespr�ch: 12,90");
		verify(outputterMock).writeLine("Gesamtgeb�hr nach Gespr�ch um 12:35 (Mondscheinzeit: false): 12,90");
		verifyNoMoreInteractions(outputterMock);
	}

	@Test
	public void testAccountWithPrivatTarif() {
		new Kunde(Tarif.PRIVAT, outputterMock).account(10, 12, 35);
		verify(outputterMock).writeLine("Berechne Gespr�ch mit 10 min um 12:35 mit Tarif 0");
		verify(outputterMock).writeLine("Preis f�r das Gespr�ch: 17,91");
		verify(outputterMock).writeLine("Gesamtgeb�hr nach Gespr�ch um 12:35 (Mondscheinzeit: false): 17,91");
		verifyNoMoreInteractions(outputterMock);
	}

}
