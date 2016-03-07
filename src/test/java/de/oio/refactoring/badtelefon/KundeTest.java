package de.oio.refactoring.badtelefon;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import de.oio.refactoring.badtelefon.output.Outputter;

@RunWith(MockitoJUnitRunner.class)
public class KundeTest {

	private Outputter outputterMock;

	@Before
	public void init() {
		outputterMock = Mockito.mock(Outputter.class);
	}

	@Test
	public void testAccountWithBusinessTarif() {
		new Kunde(Tarif.BUSINESS, outputterMock).account(10, 12, 35);
		verify(outputterMock).writeLine("Berechne Gespräch mit 10 min um 12:35 mit Tarif 1");
		verify(outputterMock).writeLine("Preis für das Gespräch: 12,90");
		verify(outputterMock).writeLine("Gesamtgebühr nach Gespräch um 12:35 (Mondscheinzeit: false): 12,90");
		verifyNoMoreInteractions(outputterMock);
	}

	@Test
	public void testAccountWithPrivatTarif() {
		new Kunde(Tarif.PRIVAT, outputterMock).account(10, 12, 35);
		verify(outputterMock).writeLine("Berechne Gespräch mit 10 min um 12:35 mit Tarif 0");
		verify(outputterMock).writeLine("Preis für das Gespräch: 17,91");
		verify(outputterMock).writeLine("Gesamtgebühr nach Gespräch um 12:35 (Mondscheinzeit: false): 17,91");
		verifyNoMoreInteractions(outputterMock);
	}

}
