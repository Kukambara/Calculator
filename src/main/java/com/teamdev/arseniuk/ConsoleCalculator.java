package com.teamdev.arseniuk;


import com.teamdev.arseniuk.impl.Calculator;

import java.util.Scanner;

public class ConsoleCalculator {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        double result;
        try {
            result = calculator.calculate(expression);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
