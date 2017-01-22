package de.oio.refactoring.badtelefon;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringOutputterTests {

	@Test
	public void testOutputToString() {
		StringOutputter stringOutput = new StringOutputter();
		stringOutput.writeLine("hello world");
		assertEquals("hello world\r\n", stringOutput.toString());
	}

}
