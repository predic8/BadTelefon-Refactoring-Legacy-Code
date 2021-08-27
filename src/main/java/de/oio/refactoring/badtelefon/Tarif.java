package de.oio.refactoring.badtelefon;

import de.oio.refactoring.badtelefon.tarif.*;

public abstract class Tarif {

	protected abstract double gesprächspreisErmitteln(int dauer, Uhrzeit zeit);
}
