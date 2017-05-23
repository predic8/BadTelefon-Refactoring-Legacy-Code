package de.oio.refactoring.badtelefon;

public class ConsoleOutputter implements Outputter {

	@Override
	public void writeLine(String message) {
		System.out.println(message);
	}
}
