package test.katas;

import org.junit.Assert;
import org.junit.Test;

import katas.StringCalculator;

public class StringCalculatorTest {

	@Test(expected = RuntimeException.class)
	public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
		StringCalculator.add("1,2,3");
	}
	
	@Test
    public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
        StringCalculator.add("1,2");
        Assert.assertTrue(true);
    }
    @Test(expected = RuntimeException.class)
    public final void whenNonNumberIsUsedThenExceptionIsThrown() {
        StringCalculator.add("1,X");
    }
	
}

