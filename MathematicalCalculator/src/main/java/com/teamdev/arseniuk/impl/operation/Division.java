package com.teamdev.arseniuk.impl.operation;

import com.teamdev.arseniuk.BinaryOperation;
import com.teamdev.arseniuk.Operation;

public class Division extends BinaryOperation {

    public Division(int parsingIndex) {
        super(Operation.DIVISION, parsingIndex);
    }

    @Override
    public double calculate(double leftOperand, double rightOperand) {
        return leftOperand / rightOperand;
    }
}
