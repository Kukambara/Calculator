package com.teamdev.arseniuk;

import java.util.HashMap;

public enum Operation {

    ADDITION('+', 2),
    SUBTRACTION('-', 2),
    MULTIPLICATION('*', 3),
    DIVISION('/', 3),
    INVOLUTION('^', 4),
    LEFT_PARENTHESIS('(', 1),
    RIGHT_PARENTHESIS(')', 1),
    END_OF_EXPRESSION('\0', 0);


    private char symbol;
    private int priority;

    private static final HashMap<Character, Operation> lookup = new HashMap<Character, Operation>();

    static {
        for (Operation operation : Operation.values())
            lookup.put(operation.getSymbol(), operation);
    }

    Operation(char symbol, int priority) {
        this.symbol = symbol;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public char getSymbol() {
        return symbol;
    }

    public static Operation get(Character symbol) {
        return lookup.get(symbol);
    }
}
