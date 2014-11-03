package com.teamdev.arseniuk.impl.operation;

import com.teamdev.arseniuk.BinaryOperation;
import com.teamdev.arseniuk.Operation;

public class Involution extends BinaryOperation {

    public Involution(int parsingIndex) {
        super(Operation.INVOLUTION, parsingIndex);
    }


    @Override
    public double calculate(double leftOperand, double rightOperand) {
        return Math.pow(leftOperand, rightOperand);
    }
}
