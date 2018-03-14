package de.lv1871.dms.Currying;

import java.util.function.BinaryOperator;

import de.lv1871.dms.Currying.domain.Versicherung;

public class VersicherungFunction {

	public static Integer calculateBeitrag(Integer anzahlVersicherungen, Versicherung versicherung) {
		return (versicherung.getBeitragMonat() * 12) + anzahlVersicherungen;
	}

	public static BinaryOperator<Integer> SUM = (a, b) -> a + b;

}
