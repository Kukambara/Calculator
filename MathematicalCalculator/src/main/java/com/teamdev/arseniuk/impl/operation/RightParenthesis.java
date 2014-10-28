package com.teamdev.arseniuk.impl.operation;

import com.teamdev.arseniuk.CalculationException;
import com.teamdev.arseniuk.Command;
import com.teamdev.arseniuk.Operation;
import com.teamdev.arseniuk.Visitor;
import com.teamdev.arseniuk.impl.CalculationStack;

public class RightParenthesis extends Command {

    public RightParenthesis() {
        super(Operation.RIGHT_PARENTHESIS);
    }

    @Override
    public void execute(CalculationStack stack) {

    }

    @Override
    public void accept(Visitor visitor) throws CalculationException {
        visitor.visit(this);
    }

}
