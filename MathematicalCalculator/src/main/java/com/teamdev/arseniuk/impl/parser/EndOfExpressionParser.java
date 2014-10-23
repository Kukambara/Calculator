package com.teamdev.arseniuk.impl.parser;

import com.teamdev.arseniuk.CalculationParser;
import com.teamdev.arseniuk.Command;
import com.teamdev.arseniuk.impl.CalculationContext;
import com.teamdev.arseniuk.impl.CalculationStack;

public class EndOfExpressionParser implements CalculationParser {

    @Override
    public Command parse(CalculationContext context) {
        if (context.getExpression().length() != context.getExpressionParsingIndex()) {
            return null;
        }

        return new Command() {
            @Override
            public void calculate(CalculationStack stack) {
            }
        };

    }
}
