package com.teamdev.arseniuk.impl.operation;

import com.teamdev.arseniuk.Command;
import com.teamdev.arseniuk.Operation;
import com.teamdev.arseniuk.Visitor;
import com.teamdev.arseniuk.impl.CalculationStack;

public class LeftParenthesis extends Command {

    public LeftParenthesis() {
        super(Operation.LEFT_PARENTHESIS);
    }

    @Override
    public void execute(CalculationStack stack) {

    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
