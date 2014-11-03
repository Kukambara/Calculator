package com.teamdev.arseniuk.impl;

import com.teamdev.arseniuk.BinaryOperation;

import java.util.ArrayDeque;
import java.util.Deque;

public class CalculationStack {
    private final Deque<Double> operandStack = new ArrayDeque<>();
    private final Deque<BinaryOperation> operationStack = new ArrayDeque<>();
    private final Deque<Integer> parenthesisStack = new ArrayDeque<>();

    public Deque<Double> getOperandStack() {
        return operandStack;
    }

    public Deque<BinaryOperation> getOperationStack() {
        return operationStack;
    }

    public Deque<Integer> getParenthesisStack() {
        return parenthesisStack;
    }

    public void pushOperand(double operand) {
        operandStack.push(operand);
    }

    public void executeTopOperation() {
        final Double rightOperand = operandStack.pop();
        final Double leftOperand = operandStack.pop();
        final BinaryOperation operation = operationStack.pop();
        final Double result = operation.calculate(leftOperand, rightOperand);
        operandStack.push(result);
    }

    public void executeAllOperations() {
        while (!operationStack.isEmpty()) {
            executeTopOperation();
        }
    }

    public void addLeftParenthesis() {
        parenthesisStack.push(operationStack.size());
    }

    public void addRightParenthesis() {
        final Integer lastLeftParenthesis = parenthesisStack.peek();
        while (operationStack.size() > lastLeftParenthesis) {
            executeTopOperation();
        }
        parenthesisStack.pop();
    }

    public void pushOperation(BinaryOperation operation) {
        if (parenthesisLastToken()) {
            operationStack.push(operation);
            return;
        }
        while (!operationStack.isEmpty() && operationStack.peek().compareTo(operation) > 0) {
            executeTopOperation();
        }
        operationStack.push(operation);
    }

    public boolean parenthesisLastToken() {
        return (!parenthesisStack.isEmpty() && operationStack.size() == parenthesisStack.peek());
    }

}
