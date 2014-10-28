package com.teamdev.arseniuk;

import com.teamdev.arseniuk.impl.CalculationStack;

public abstract class Command implements Token {

    private final Operation operation;

    public Command(Operation operation) {
        this.operation = operation;
    }

    public abstract void execute(CalculationStack stack);

    public Operation getOperation() {
        return operation;
    }

    public int getPriority() {
        return operation.getPriority();
    }

}
