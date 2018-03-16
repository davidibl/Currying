package de.lv1871.dms.Currying.domain;

import java.util.function.Function;

import de.lv1871.dms.Currying.ExtendedFunction;
import de.lv1871.dms.Currying.TriFunction;

public class Gehaltsregeln {

	public static ExtendedFunction<Double, Double, Double> SUM = (a, b) -> a + b;
	public static ExtendedFunction<Double, Double, Double> SUBTRACT = (a, b) -> b - a;
	public static ExtendedFunction<Double, Double, Double> STEUERSATZ_ABZIEHEN = (a, b) -> b - (b * a);
	public static Function<Double, Double> STANDARD_STEUERSATZ_ABZIEHEN = STEUERSATZ_ABZIEHEN.curryWith(0.54);
	public static Function<Double, Double> ZULAGE_ADDIEREN = SUM.curryWith(102.0);
	public static ExtendedFunction<Double, Double, Double> BONUS = SUM;
	public static TriFunction<ExtendedFunction<Double, Double, Double>, Double, Double, Double> VORGESETZTEN_SPECIAL = (
			func, a, b) -> func.apply(a, b);

}
