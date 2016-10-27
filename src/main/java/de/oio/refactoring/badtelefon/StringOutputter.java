package de.oio.refactoring.badtelefon;

import java.io.PrintWriter;
import java.io.StringWriter;

public class StringOutputter implements Outputter {

	private StringWriter stringWriter = new StringWriter();
	private PrintWriter printWriter = new PrintWriter(stringWriter);

	@Override
	public void writeLine(String message) {
		printWriter.println(message);
	}

	@Override
	public String toString() {
		return stringWriter.toString();
	}

}
