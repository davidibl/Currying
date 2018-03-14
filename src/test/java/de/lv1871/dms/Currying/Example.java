package de.lv1871.dms.Currying;

import static org.junit.Assert.assertEquals;

import java.util.function.BiFunction;
import java.util.function.Function;

import org.junit.Test;

public class Example {

	private static BiFunction<Integer, Integer, Integer> ADD = (a, b) -> a + b;
	private static Function<Integer, Function<Integer, Integer>> ADD_NUMBER = a -> b -> ADD.apply(a, b);
	private static Function<Integer, Integer> ADD5 = ADD_NUMBER.apply(5);

	@Test
	public void testAdd5() {
		assertEquals(new Integer(7), ADD5.apply(2));
	}

}
