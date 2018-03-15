package de.lv1871.dms.Currying.domain;

import de.lv1871.dms.Currying.ExtendedFunction;

public class Converter {

	public static ExtendedFunction<Double, Double, Double> CONVERT = (a, b) -> a * b;
}
