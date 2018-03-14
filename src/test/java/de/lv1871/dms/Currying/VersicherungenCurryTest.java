package de.lv1871.dms.Currying;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.junit.Test;

import de.lv1871.dms.Currying.domain.Versicherung;
import de.lv1871.dms.Currying.domain.Versicherung2;

public class VersicherungenCurryTest {

	/**
	 * Schreibt eine Funktion in VersicherungFunction, die die Methode
	 * getVersicherungsbeitrag derart modifiziert, dass eine partielle Applikation
	 * mit der Anzahl der Versicherungen stattfinden kann. Das Resultat der Partial
	 * Application soll dann in Map verwendet werden um schlußendlich die
	 * Beitragssummer zu berechnen. Die Function zur partiellen Applikation soll
	 * vollkommen wiederverwendbar (generisch) sein und curry heißen.
	 */
	@Test
	public void testGetVersicherungBeitrag() {
		List<Versicherung> versicherungen = new ArrayList<>();
		versicherungen.add(new Versicherung(23));
		versicherungen.add(new Versicherung(46));

		Function<Versicherung, Integer> toBeitrag = null;

		// formatter:off
		Integer beitragGesamt = versicherungen.stream().map(toBeitrag).reduce(VersicherungFunction.SUM).get();
		// formatter:on

		assertEquals(new Integer(832), beitragGesamt);
	}

	/**
	 * Eine zweite Versicherung enthält keinen Monatsbeitrag sondern nur den
	 * Jahresbeitrag. Erweitert den Algorithmus dahingehend dass hier keine
	 * Multiplikation mit 12 mehr stattfinden. Optimiert den Code soweit als möglich
	 */
	@Test
	public void testGetVersicherungBeitrag2() {
		List<Versicherung2> versicherungen = new ArrayList<>();
		versicherungen.add(new Versicherung2(1024));
		versicherungen.add(new Versicherung2(1048));

		// formatter:off
		Integer beitragGesamt = null;
		// formatter:on

		assertEquals(new Integer(2076), beitragGesamt);
	}

	/**
	 * Es stellt sich heraus dass eine Beitragskorrektur um 4 Euro nach unten bei
	 * den Jahresbeiträgen stattfinden muss. Entwickelt den Algorithmus dahingehend
	 * weiter dass die Korrektur ohne Änderung auf beide Versicherungstypen
	 * angewendet werden kann.
	 */
	@Test
	public void testBeitragskorrektur() {
		List<Versicherung2> versicherungen = new ArrayList<>();
		versicherungen.add(new Versicherung2(1024));
		versicherungen.add(new Versicherung2(1048));

		// formatter:off
		Integer beitragGesamt = null;
		// formatter:on

		assertEquals(new Integer(2068), beitragGesamt);
	}

}