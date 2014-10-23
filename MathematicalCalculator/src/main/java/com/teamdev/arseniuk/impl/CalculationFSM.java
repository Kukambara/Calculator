package com.teamdev.arseniuk.impl;

import com.teamdev.arseniuk.CalculationException;
import com.teamdev.arseniuk.FiniteStateMachine;
import com.teamdev.arseniuk.MathCalculator;

public class CalculationFSM extends FiniteStateMachine<State, Double, CalculationContext> implements MathCalculator {

    @Override
    protected Double finish(CalculationContext context) {
        return context.getStack().getOperandStack().pop();
    }

    @Override
    protected void deadlock(CalculationContext context, State currentState) {
        throw new IllegalStateException("Deadlock in state " + currentState + " at position " +
                context.getExpressionParsingIndex());
    }

    @Override
    public double calculate(String expression) throws CalculationException {
        return run(new CalculationContext(expression));
    }
}
