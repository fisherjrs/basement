package test.katas;

import org.junit.Assert;
import org.junit.Test;

import katas.StringCalculator;

public class StringCalculatorTest {
	
	@Test(expected = RuntimeException.class)
	public final void whenMoreThanTwoNumbersAreUsedThenExceptionIsThrown() {
		StringCalculator.add("2,4,6");
	}
	
	@Test
	public final void whenTwoNumbersAreUsedNoExceptionisThrown() {
		StringCalculator.add("3,7");
	}
	
	@Test(expected = RuntimeException.class) 
	public final void whenNonNumberIsUsedExceptionIsThrown() {
		StringCalculator.add("3,T");
	}
	
	@Test
	public final void whenEmptyStringIsUsedThenReturnValueIs0() {
		Assert.assertEquals(0, StringCalculator.add(""));
	}
	
	@Test
	public final void whenOneNumberIsUsedThenReturnSameNumber() {
		Assert.assertEquals(3, StringCalculator.add("3"));
	}
	
	@Test 
	public final void whenTwoNumbersAreUsedThenReturnSumOfNumbers() {
		Assert.assertEquals(9, StringCalculator.add("4,5"));
	}
}