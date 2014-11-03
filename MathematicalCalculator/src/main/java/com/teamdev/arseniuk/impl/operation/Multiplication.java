package com.teamdev.arseniuk.impl.operation;

import com.teamdev.arseniuk.BinaryOperation;
import com.teamdev.arseniuk.Operation;

public class Multiplication extends BinaryOperation {

    public Multiplication(int parsingIndex) {
        super(Operation.MULTIPLICATION, parsingIndex);
    }

    @Override
    public double calculate(double leftOperand, double rightOperand) {
        return leftOperand * rightOperand;
    }
}
