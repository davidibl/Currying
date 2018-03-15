package de.lv1871.dms.Currying.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import de.lv1871.dms.Currying.ExtendedFunction;

public class Gehaltsrechner {

	private List<Function<Double, Double>> regeln = new ArrayList<>();
	private Integer limit;

	public static Gehaltsrechner create() {
		return new Gehaltsrechner();
	}

	public Gehaltsrechner with(Function<Double, Double> regel) {
		this.regeln.add(regel);
		return this;
	}

	public Gehaltsrechner withLimit(Integer limit) {
		this.limit = limit;
		return this;
	}

	public Double berechne(Double basisgehalt) {
		// @formatter:off
		return ROUND_DEFAULT.apply(regeln
			.stream()
			.limit(this.getLimit())
			.reduce(Function.identity(), Function::andThen)
			.apply(basisgehalt));
		// @formatter:on
	}

	private static ExtendedFunction<Integer, Double, Double> ROUND = (Integer places, Double value) -> {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	};

	private static Function<Double, Double> ROUND_DEFAULT = ROUND.curry().apply(2);

	private int getLimit() {
		return (limit == null) ? regeln.size() : limit;
	}

}
