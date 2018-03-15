package de.lv1871.dms.Currying;

import java.util.function.BinaryOperator;
import java.util.function.Function;

import de.lv1871.dms.Currying.domain.Versicherung;

public class VersicherungFunction {

	public static Integer calculateBeitrag(Integer anzahlVersicherungen, Versicherung versicherung) {
		return (versicherung.getBeitragMonat() * 12) + anzahlVersicherungen;
	}

	public static Integer calculateBeitragExtended(Integer anzahlVersicherungen, Integer beitragsfaktor,
			Integer beitrag) {
		return (beitrag * beitragsfaktor) + anzahlVersicherungen;
	}

	public static ExtendedFunction<Integer, Versicherung, Integer> beitragsrechnung = VersicherungFunction::calculateBeitrag;
	public static TriFunction<Integer, Integer, Integer, Integer> beitragsrechnungExtended = VersicherungFunction::calculateBeitragExtended;
	public static BinaryOperator<Integer> SUM = (a, b) -> a + b;
	public static Function<Integer, Integer> beitragskorrketur = (a) -> a - 4;

}
