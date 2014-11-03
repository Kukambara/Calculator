package com.teamdev.arseniuk.impl.operation;

import com.teamdev.arseniuk.CalculationException;
import com.teamdev.arseniuk.Token;
import com.teamdev.arseniuk.impl.CalculationStack;

public class RightParenthesis extends Token {

    public RightParenthesis(int parsingIndex) {
        super(parsingIndex);
    }

    @Override
    public void execute(CalculationStack stack) throws CalculationException {
        if (stack.getParenthesisStack().isEmpty()) {
            throw new CalculationException("Left parenthesis missed at position ", getParsingIndex());
        }
        stack.addRightParenthesis();
    }
}
