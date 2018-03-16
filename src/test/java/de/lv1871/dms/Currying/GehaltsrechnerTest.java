package de.lv1871.dms.Currying;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.lv1871.dms.Currying.domain.Gehaltsrechner;
import de.lv1871.dms.Currying.domain.Gehaltsregeln;

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
		// @formatter:off
		Double gehalt = Gehaltsrechner
			.create()
			.with(Gehaltsregeln.ZULAGE_ADDIEREN)
			.with(Gehaltsregeln.BONUS.curryWith(54.0))
			.with(Gehaltsregeln.STANDARD_STEUERSATZ_ABZIEHEN)
			.with(Gehaltsregeln.VORGESETZTEN_SPECIAL.curryWith(Gehaltsregeln.SUBTRACT).curryWith(23.0))
			.berechne(2300.0);
		// @formatter:on

		assertEquals(new Double(1106.76), gehalt);
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
		// @formatter:off
		Double gehalt = Gehaltsrechner
			.create()
			.with(Gehaltsregeln.ZULAGE_ADDIEREN)
			.with(Gehaltsregeln.STANDARD_STEUERSATZ_ABZIEHEN)
			.with(Gehaltsregeln.STEUERSATZ_ABZIEHEN.curryWith(0.01))
			.berechne(2120.0);
		// @formatter:on

		assertEquals(new Double(1011.9), gehalt);
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
		// @formatter:off
		Double gehalt = Gehaltsrechner
			.create()
			.with(Gehaltsregeln.ZULAGE_ADDIEREN)
			.with(Gehaltsregeln.BONUS.curryWith(102.0))
			.with(Gehaltsregeln.STANDARD_STEUERSATZ_ABZIEHEN)
			.with(Gehaltsregeln.STEUERSATZ_ABZIEHEN.curryWith(0.12))
			.with(Gehaltsregeln.VORGESETZTEN_SPECIAL.curryWith(Gehaltsregeln.SUM).curryWith(233.0))
			.berechne(1020.0);
		// @formatter:on

		assertEquals(new Double(728.48), gehalt);
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
		// @formatter:off
		Gehaltsrechner gehaltsrechnerKonfiguriert = Gehaltsrechner
			.create()
			.with(Gehaltsregeln.ZULAGE_ADDIEREN)
			.with(Gehaltsregeln.BONUS.curryWith(102.0))
			.with(Gehaltsregeln.STANDARD_STEUERSATZ_ABZIEHEN)
			.with(Gehaltsregeln.STEUERSATZ_ABZIEHEN.curryWith(0.12))
			.with(Gehaltsregeln.VORGESETZTEN_SPECIAL.curryWith(Gehaltsregeln.SUM).curryWith(233.0));
		// @formatter:on

		Double gehaltNachRegelDrei = gehaltsrechnerKonfiguriert.withLimit(3).berechne(1020.0);
		Double gehaltNachRegelAlle = gehaltsrechnerKonfiguriert.withLimit(null).berechne(1020.0);

		assertEquals(new Double(563.04), gehaltNachRegelDrei);
		assertEquals(new Double(728.48), gehaltNachRegelAlle);
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
		// @formatter:off
		ExtendedFunction<Double, Double, Double> MULTIPLY = (a, b) -> a * b;

		Double gehalt = Gehaltsrechner
			.create()
			.with(MULTIPLY.curryWith(3.0))
			.with(Gehaltsregeln.ZULAGE_ADDIEREN)
			.with(Gehaltsregeln.STANDARD_STEUERSATZ_ABZIEHEN)
			.with(Gehaltsregeln.STEUERSATZ_ABZIEHEN.curryWith(0.12))
			.berechne(1020.0);
		// @formatter:on

		assertEquals(new Double(1279.98), gehalt);
	}

}
