package com.teamdev.arseniuk.impl.parser;

import com.teamdev.arseniuk.CalculationParser;
import com.teamdev.arseniuk.Token;
import com.teamdev.arseniuk.impl.CalculationContext;
import com.teamdev.arseniuk.impl.EndOfExpression;

public class EndOfExpressionParser implements CalculationParser {

    @Override
    public Token parse(CalculationContext context) {
        if (context.getExpression().length() != context.getExpressionParsingIndex()) {
            return null;
        }
        final EndOfExpression endOfExpression = new EndOfExpression();
        context.getStack().getOperationStack().push(endOfExpression);
        return endOfExpression;

    }
}
