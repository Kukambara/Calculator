package com.teamdev.arseniuk.impl.operation;

import com.teamdev.arseniuk.BinaryOperation;
import com.teamdev.arseniuk.Operation;

public class Addition extends BinaryOperation {

    public Addition(int parsingIndex) {
        super(Operation.ADDITION, parsingIndex);
    }

    @Override
    public double calculate(double leftOperand, double rightOperand) {
        return leftOperand + rightOperand;
    }
}
