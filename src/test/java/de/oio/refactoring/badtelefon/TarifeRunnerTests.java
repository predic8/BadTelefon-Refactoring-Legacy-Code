package de.oio.refactoring.badtelefon;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import org.approvaltests.Approvals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TarifeRunnerTests {

	private PrintStream originalSysOut;
	private ByteArrayOutputStream consoleStream;

	@Before
	public void init() {
		originalSysOut = System.out;
		consoleStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(consoleStream);
		System.setOut(printStream);
	}

	@Test
	public void testSimpleOutput() {
		System.out.println("Hallo Publikum!");
		System.out.print("Hallo Falk!");
		assertEquals("Hallo Publikum!\r\nHallo Falk!", consoleStream.toString());
	}

	@Test
	public void testRunnerWithApprovals() throws Exception {
		new TarifeRunnerForTest().run();
		Approvals.verify(consoleStream.toString());
	}

	private class TarifeRunnerForTest extends TarifeRunner {
		@Override
		protected Random getRandom() {
			return new Random(42);
		}
	}

	
	@After
	public void teardown() {
		System.setOut(originalSysOut);
	}

}
