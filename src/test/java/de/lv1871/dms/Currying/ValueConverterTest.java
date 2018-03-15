package de.lv1871.dms.Currying;

import static org.junit.Assert.assertEquals;

import java.util.function.Function;

import org.junit.Test;

import de.lv1871.dms.Currying.domain.Converter;

public class ValueConverterTest {

	/**
	 * Implementiert einen Converter der auf Basis eines Werts die Neuberechnung
	 * durchführt. Verwendet hierfür Currying.
	 */
	@Test
	public void testValueConvertingEuroDollar() {
		Function<Double, Double> euroDollarConverter = Converter.CONVERT.curry().apply(2.51); // Converter.base(2.51);

		assertEquals(new Double(5.02), euroDollarConverter.apply(2.0));
	}

	@Test
	public void testValueConvertingDollarEuro() {
		Function<Double, Double> dollarEuroConverter = Converter.CONVERT.curry().apply(0.76);
		; // Converter.base(0.76);

		assertEquals(new Double(1.52), dollarEuroConverter.apply(2.0));
	}
}
