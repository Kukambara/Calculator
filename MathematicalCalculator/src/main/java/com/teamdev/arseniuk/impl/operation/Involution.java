package com.teamdev.arseniuk.impl.operation;

import com.teamdev.arseniuk.CalculationException;
import com.teamdev.arseniuk.Command;
import com.teamdev.arseniuk.Operation;
import com.teamdev.arseniuk.Visitor;
import com.teamdev.arseniuk.impl.CalculationStack;

import java.util.Deque;

public class Involution extends Command {

    public Involution() {
        super(Operation.INVOLUTION);
    }

    @Override
    public void execute(CalculationStack stack) {
        final Deque<Double> operands = stack.getOperandStack();
        final double secondOperand = operands.pop();
        final double firstOperand = operands.pop();
        final double result = Math.pow(firstOperand, secondOperand);
        operands.push(result);
    }


    @Override
    public void accept(Visitor visitor) throws CalculationException {
        visitor.visit(this);
    }

}
