package com.teamdev.arseniuk.impl.parser;

import com.teamdev.arseniuk.*;
import com.teamdev.arseniuk.impl.CalculationContext;
import com.teamdev.arseniuk.impl.operation.LeftParenthesis;

import java.util.HashMap;

import static com.teamdev.arseniuk.Operation.LEFT_PARENTHESIS;

public class LeftParenthesisParser implements CalculationParser {
    private final HashMap<Operation, CommandCreator> operations = new HashMap<Operation, CommandCreator>() {{
        put(LEFT_PARENTHESIS, new CommandCreator() {
            @Override
            public Command getInstance() {
                return new LeftParenthesis();
            }
        });
    }};

    @Override
    public Token parse(CalculationContext context) {
        final String expression = context.getExpression();
        final Token token;
        int parsingIndex = context.getExpressionParsingIndex();
        while (parsingIndex != expression.length()) {
            final char operationSymbol = expression.charAt(parsingIndex);
            if (!Character.isSpaceChar(operationSymbol)) {
                final CommandCreator creator = operations.get(Operation.get(operationSymbol));
                if (creator != null) {
                    token = creator.getInstance();
                    parsingIndex++;
                    context.setExpressionParsingIndex(parsingIndex);
                    return token;
                }
            }
            parsingIndex++;
        }
        return null;
    }
}
