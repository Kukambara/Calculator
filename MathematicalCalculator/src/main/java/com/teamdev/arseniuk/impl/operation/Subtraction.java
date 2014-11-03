package com.teamdev.arseniuk.impl.operation;

import com.teamdev.arseniuk.BinaryOperation;
import com.teamdev.arseniuk.Operation;

public class Subtraction extends BinaryOperation {

    public Subtraction(int parsingIndex) {
        super(Operation.SUBTRACTION, parsingIndex);
    }

    @Override
    public double calculate(double leftOperand, double rightOperand) {
        return leftOperand - rightOperand;
    }

}
