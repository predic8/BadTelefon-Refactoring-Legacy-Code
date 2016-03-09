package de.oio.refactoring.badtelefon;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;
import org.powermock.reflect.Whitebox;

public class MondscheinTest {

	@Test
	public void testMondschein() {
		assertEquals(true, invokeIsMondschein(0));
		assertEquals(true, invokeIsMondschein(8));

		assertEquals(false, invokeIsMondschein(9));
		assertEquals(false, invokeIsMondschein(12));
		assertEquals(false, invokeIsMondschein(17));
		assertEquals(false, invokeIsMondschein(18));

		assertEquals(true, invokeIsMondschein(19));
		assertEquals(true, invokeIsMondschein(23));
		assertEquals(true, invokeIsMondschein(24));
		assertEquals(true, invokeIsMondschein(30));
		assertEquals(true, invokeIsMondschein(-1));
	}

	private boolean invokeIsMondschein(int hour) {
		try {
			Method method = Kunde.class.getDeclaredMethod("isMondschein", Integer.TYPE);
			method.setAccessible(true);
			return (boolean) method.invoke(null, hour);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Test
	public void testInvokeWithWhitebox() throws Exception {
		assertEquals(true, Whitebox.invokeMethod(Kunde.class, "isMondschein", 8));
		assertEquals(false, Whitebox.invokeMethod(Kunde.class, "isMondschein", 10));
	}
}
