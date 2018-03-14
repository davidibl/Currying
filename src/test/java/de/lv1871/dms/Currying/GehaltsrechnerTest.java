package de.lv1871.dms.Currying;

import org.junit.Test;

public class GehaltsrechnerTest {

	// @formatter:off
	/**
	 * Ein Gehaltsrechner soll implementiert werden. Hierbei sind folgende Regeln zu beachten:
	 * 
	 * 1. Vom Gehalt wird ein Steuersatz von 54% abgezogen
	 * 2. Eine Bruttozulage in Höhe von 102 € wird addiert
	 * 3. Eine reginal Unterschiedliche Steuer kann unter Umständen abgezogen werden
	 * 4. Ein Bonus kann optional hinzu addiert werden.
	 * 5. Jeder Vorgesetzte schlägt was auf oder zieht was ab.
	 * 
	 * Die Regeln werden stets in der Reihenfolge 2 -> 4 -> 1 -> 3 -> 5 angewendet.
	 * 
	 * Die Regeln solle isoliert werden um sie auch in anderen Anwendungen zu verwenden.
	 * Der Rechner soll ein BuilderPattner implementieren und die Berechnung mit der Methode berechne durchführen.
	 * 
	 * Die Methode berechne soll zudem einen optionalen Parameter entgegen nehmen, der es ermöglicht bis zu einer
	 * bestimmten Regel zu berechnen: Parameter 2 bewirkt das zwei der Regeln für die Berechnung angewendet werden.
	 */
	// @formatter:on

	// @formatter:off
	/**
	 * Für diesen Mitarbeiter gelten folgende Regeln:
	 * 
	 * Basisgehalt: 2300
	 * Bonus: 54
	 * Vorgesetztenspecial: -23
	 */
	// @formatter:on
	@Test
	public void testGehaltsberechnungA() {

	}

	// @formatter:off
	/**
	 * Für diesen Mitarbeiter gelten folgende Regeln:
	 * 
	 * Basisgehalt: 2120
	 * reginale Steuer: 1%
	 * Vorgesetztenspecial: 0
	 */
	// @formatter:on
	@Test
	public void testGehaltsberechnungB() {

	}

	// @formatter:off
	/**
	 * Für diesen Mitarbeiter gelten folgende Regeln:
	 * 
	 * Basisgehalt: 1020
	 * reginale Steuer: 12%
	 * Vorgesetztenspecial: +233
	 * Bonus: 102
	 */
	// @formatter:on
	@Test
	public void testGehaltsberechnungC() {

	}

	// @formatter:off
	/**
	 * Für diesen Mitarbeiter gelten folgende Regeln:
	 * 
	 * Basisgehalt: 1020
	 * reginale Steuer: 12%
	 * Vorgesetztenspecial: +233
	 * Bonus: 102
	 */
	// @formatter:on
	@Test
	public void testGehaltsberechnungCMitAssertionNachErsterDritterUndLetzterRegel() {

	}

	// @formatter:off
	/**
	 * Für diesen Mitarbeiter gelten folgende Regeln:
	 * 
	 * Basisgehalt: 1020
	 * reginale Steuer: 12%
	 * Vorgesetztenspecial: +-0
	 * Dieser Mitarbeiter bekommt eine Sonderlocke. Sein Gehalt wird ganz am Anfang verdreifacht!
	 * Hierfür darf keine neue Regel implementiert werden.
	 */
	// @formatter:on
	@Test
	public void testGehaltsberechnungDSonderlocke() {

	}

}
