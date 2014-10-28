package com.teamdev.arseniuk.impl.parser;

import com.teamdev.arseniuk.*;
import com.teamdev.arseniuk.impl.CalculationContext;
import com.teamdev.arseniuk.impl.operation.*;

import java.util.HashMap;

import static com.teamdev.arseniuk.Operation.*;

public class OperationParser implements CalculationParser {

    private final HashMap<Operation, CommandCreator> operations = new HashMap<Operation, CommandCreator>() {{
        put(ADDITION, new CommandCreator() {
            @Override
            public Command getInstance() {
                return new Addition();
            }
        });
        put(SUBTRACTION, new CommandCreator() {
            @Override
            public Command getInstance() {
                return new Subtraction();
            }
        });
        put(MULTIPLICATION, new CommandCreator() {
            @Override
            public Command getInstance() {
                return new Multiplication();
            }
        });
        put(DIVISION, new CommandCreator() {
            @Override
            public Command getInstance() {
                return new Division();
            }
        });
        put(INVOLUTION, new CommandCreator() {
            @Override
            public Command getInstance() {
                return new Involution();
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
                } else {
                    return null;
                }
            }
            parsingIndex++;
        }
        return null;
    }
}
