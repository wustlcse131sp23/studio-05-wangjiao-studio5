package studio5.tests;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import studio5.Methods;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SubstituteAllTest {
	@Test
	public void test1Round() {
		String source = "r is a r is a r is a r.";

		String actual = Methods.substituteAll(source, 'r', "rose");
		assertEquals("rose is a rose is a rose is a rose.", actual);
	}

	@Test
	public void test2Rounds() {
		String source = "b is t, t b,";
		
		String actual = Methods.substituteAll(source, 't', "o");
		assertEquals("b is o, o b,", actual);

		String actualPrime = Methods.substituteAll(actual, 'b', "beauty");
		assertEquals("beauty is o, o beauty,", actualPrime);

		String actualPrimePrime = Methods.substituteAll(actualPrime, 'o', "truth");
		assertEquals("beauty is truth, truth beauty,", actualPrimePrime);
	}

	@Test
	public void test3Rounds() {
		String source = "2 b or ! 2 b";

		String actual = Methods.substituteAll(source, '2', "to");
		assertEquals("to b or ! to b", actual);

		String actualPrime = Methods.substituteAll(actual, 'b', "be");
		assertEquals("to be or ! to be", actualPrime);

		String actualPrimePrime = Methods.substituteAll(actualPrime, '!', "not");
		assertEquals("to be or not to be", actualPrimePrime);
	}
}
