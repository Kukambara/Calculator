package com.teamdev.arseniuk;

import com.teamdev.arseniuk.impl.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculationTest {

    @Test
    public void testNumber() throws Exception {
        final double expected = 200;
        final String input = "200";
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.calculate(input), 0);
    }

    @Test
    public void testDotFirstNumber() throws Exception {
        final double expected = .200;
        final String input = ".200";
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.calculate(input), 0);
    }

    @Test
    public void testSimpleAddition() throws Exception {
        final double expected = 200;
        final String input = "100 + 100";
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.calculate(input), 0);
    }

    @Test
    public void testSimpleSubtraction() throws Exception {
        final double expected = 50;
        final String input = "150 - 100";
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.calculate(input), 0);
    }

    @Test
    public void testSimpleDivision() throws Exception {
        final double expected = 30;
        final String input = "90 / 3";
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.calculate(input), 0);
    }

    @Test
    public void testSimpleMultiplication() throws Exception {
        final double expected = 100;
        final String input = "20 * 5";
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.calculate(input), 0);
    }

    @Test
    public void testSimpleInvolution() throws Exception {
        final double expected = 1024;
        final String input = "2 ^ 10";
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.calculate(input), 0);
    }

    @Test
    public void testCalculationWithDifferentPriority() throws Exception {
        final double expected = 70;
        final String input = "10 + 20 * 3";
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.calculate(input), 0);
    }

    @Test
    public void testCalculationWithParenthesis() throws Exception {
        final double expected = 90;
        final String input = "(10 + 20 )* 3";
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.calculate(input), 0);
    }

    @Test
    public void testCalculationWithInnerParenthesis() throws Exception {
        final double expected = -21;
        final String input = "(10 + (1*3) - 20 )* 3";
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.calculate(input), 0);
    }

    @Test(expected = CalculationException.class)
    public void testIncorrectParenthesis() throws Exception {
        final String input = "(10 + (1*3) - 20 * 3";
        Calculator calculator = new Calculator();
        calculator.calculate(input);
    }


}
