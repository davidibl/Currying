package de.lv1871.dms.Currying;

import static org.junit.Assert.assertEquals;

import java.util.function.Function;

public class ValueConverterTest {

	/**
	 * Implementiert einen Converter der auf Basis eines Werts die Neuberechnung
	 * durchführt. Verwendet hierfür Currying.
	 */
	public void testValueConvertingEuroDollar() {
		Function<Double, Double> euroDollarConverter = null; // Converter.base(2.51);

		assertEquals(new Double(5.02), euroDollarConverter.apply(2.0));
	}

	public void testValueConvertingDollarEuro() {
		Function<Double, Double> dollarEuroConverter = null; // Converter.base(0.76);

		assertEquals(new Double(1.52), dollarEuroConverter.apply(2.0));
	}
}
