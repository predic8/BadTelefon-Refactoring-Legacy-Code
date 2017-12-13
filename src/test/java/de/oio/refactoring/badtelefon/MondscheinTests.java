package de.oio.refactoring.badtelefon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MondscheinTests {
	@Test
	public void testMondschein() {
		assertEquals(true, Kunde.isMondschein(0));
		assertEquals(true, Kunde.isMondschein(8));

		assertEquals(false, Kunde.isMondschein(9));
		assertEquals(false, Kunde.isMondschein(12));
		assertEquals(false, Kunde.isMondschein(17));
		assertEquals(false, Kunde.isMondschein(18));

		assertEquals(true, Kunde.isMondschein(19));
		assertEquals(true, Kunde.isMondschein(23));
		assertEquals(true, Kunde.isMondschein(24));
		assertEquals(true, Kunde.isMondschein(30));
		assertEquals(true, Kunde.isMondschein(-1));
	}


}
