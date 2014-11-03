package com.teamdev.arseniuk.impl.operation;

import com.teamdev.arseniuk.Token;
import com.teamdev.arseniuk.impl.CalculationStack;

public class LeftParenthesis extends Token {


    public LeftParenthesis(int parsingIndex) {
        super(parsingIndex);
    }

    @Override
    public void execute(CalculationStack stack) {
        stack.addLeftParenthesis();
    }
}
