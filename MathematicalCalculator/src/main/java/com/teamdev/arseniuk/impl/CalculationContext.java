package com.teamdev.arseniuk.impl;

import com.teamdev.arseniuk.StateAcceptor;
import com.teamdev.arseniuk.StateMachineContext;
import com.teamdev.arseniuk.TransitionMatrix;

public class CalculationContext implements StateMachineContext<State, CalculationContext> {
    private final CalculationMatrix matrix = new CalculationMatrix();
    private final CalculationAcceptor acceptor = new CalculationAcceptor();
    private final CalculationStack stack = new CalculationStack();

    private final String expression;
    private int expressionParsingIndex;

    public CalculationContext(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public int getExpressionParsingIndex() {
        return expressionParsingIndex;
    }

    public void setExpressionParsingIndex(int expressionParsingIndex) {
        this.expressionParsingIndex = expressionParsingIndex;
    }

    public CalculationStack getStack() {
        return stack;
    }

    @Override
    public TransitionMatrix<State> getTransitionMatrix() {
        return matrix;
    }

    @Override
    public StateAcceptor<State, CalculationContext> getAcceptor() {
        return acceptor;
    }


}
