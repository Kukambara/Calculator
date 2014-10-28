package com.teamdev.arseniuk.impl;

import com.teamdev.arseniuk.CalculationException;
import com.teamdev.arseniuk.Command;
import com.teamdev.arseniuk.Operation;
import com.teamdev.arseniuk.Visitor;

public class EndOfExpression extends Command {

    public EndOfExpression() {
        super(Operation.END_OF_EXPRESSION);
    }

    @Override
    public void execute(CalculationStack stack) {

    }

    @Override
    public void accept(Visitor visitor) throws CalculationException {
        visitor.visit(this);
    }
}
