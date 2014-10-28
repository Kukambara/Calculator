package com.teamdev.arseniuk;

import com.teamdev.arseniuk.impl.Calculator;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CalculationTest extends TestCase {

    public CalculationTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(CalculationTest.class);
    }

    public void testNumber() throws Exception {
        final double expected = 200;
        final String input = "200";
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.calculate(input));
    }

    public void testDotFirstNumber() throws Exception {
        final double expected = .200;
        final String input = ".200";
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.calculate(input));
    }


    public void testSimpleAddition() throws Exception {
        final double expected = 200;
        final String input = "100 + 100";
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.calculate(input));
    }

    public void testSimpleSubtraction() throws Exception {
        final double expected = 50;
        final String input = "150 - 100";
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.calculate(input));
    }


    public void testSimpleDivision() throws Exception {
        final double expected = 30;
        final String input = "90 / 3";
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.calculate(input));
    }


    public void testSimpleMultiplication() throws Exception {
        final double expected = 100;
        final String input = "20 * 5";
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.calculate(input));
    }


    public void testSimpleInvolution() throws Exception {
        final double expected = 1024;
        final String input = "2 ^ 10";
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.calculate(input));
    }


    public void testCalculationWithDifferentPriority() throws Exception {
        final double expected = 70;
        final String input = "10 + 20 * 3";
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.calculate(input));
    }

    public void testCalculationWithParenthesis() throws Exception {
        final double expected = 90;
        final String input = "(10 + 20 )* 3";
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.calculate(input));
    }

    public void testCalculationWithInnerParenthesis() throws Exception {
        final double expected = -21;
        final String input = "(10 + (1*3) - 20 )* 3";
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.calculate(input));
    }


    public void testIncorrectParenthesis() throws Exception {
        final double expected = -21;
        final String input = "(10 + (1*3) - 20 )* 3";
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.calculate(input));
    }

}
