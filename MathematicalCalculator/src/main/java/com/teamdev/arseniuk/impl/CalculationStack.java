package com.teamdev.arseniuk.impl;

import com.teamdev.arseniuk.Command;

import java.util.ArrayDeque;
import java.util.Deque;

public class CalculationStack {
    private final Deque<Double> operandStack = new ArrayDeque<>();
    private final Deque<Command> operationStack = new ArrayDeque<>();
    private int openedParenthesisCount = 0;

    public Deque<Double> getOperandStack() {
        return operandStack;
    }

    public Deque<Command> getOperationStack() {
        return operationStack;
    }

    public void incrementParenthesis() {
        openedParenthesisCount++;
    }

    public void decrementParenthesis() {
        openedParenthesisCount--;
    }

    public int getOpenedParenthesisCount() {
        return openedParenthesisCount;
    }
}
