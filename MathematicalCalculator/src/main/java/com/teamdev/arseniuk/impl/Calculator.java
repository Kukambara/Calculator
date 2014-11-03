package com.teamdev.arseniuk.impl;

import com.teamdev.arseniuk.CalculationException;
import com.teamdev.arseniuk.FiniteStateMachine;
import com.teamdev.arseniuk.MathCalculator;

public class Calculator extends FiniteStateMachine<State, Double, CalculationContext, CalculationException> implements MathCalculator {

    @Override
    protected Double finish(CalculationContext context) {
        return context.getStack().getOperandStack().pop();
    }

    @Override
    protected void deadlock(CalculationContext context, State currentState) throws CalculationException {
        throw new CalculationException("Deadlock in state " + currentState + " at position ", context.getReader().getIndex());
    }

    @Override
    public double calculate(String expression) throws CalculationException {
        return run(new CalculationContext(expression));
    }
}
