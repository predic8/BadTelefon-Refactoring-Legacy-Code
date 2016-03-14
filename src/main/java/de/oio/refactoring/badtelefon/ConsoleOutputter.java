package de.oio.refactoring.badtelefon;

public class ConsoleOutputter implements Outputter {

	/* (non-Javadoc)
	 * @see de.oio.refactoring.badtelefon.Outputter#writeToConsole(java.lang.String)
	 */
	@Override
	public void writeLine(String message1) {
		System.out.println(message1);
	}

}
