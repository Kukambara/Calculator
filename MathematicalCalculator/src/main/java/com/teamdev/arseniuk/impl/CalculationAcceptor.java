package com.teamdev.arseniuk.impl;

import com.teamdev.arseniuk.*;
import com.teamdev.arseniuk.impl.parser.*;

import java.util.HashMap;

import static com.teamdev.arseniuk.impl.State.*;

public class CalculationAcceptor implements StateAcceptor<State, CalculationContext> {

    private final HashMap<State, CalculationParser> parsers = new HashMap<State, CalculationParser>() {{
        put(NUMBER, new NumberParser());
        put(BINARY_OPERATION, new OperationParser());
        put(LEFT_PARENTHESIS, new LeftParenthesisParser());
        put(RIGHT_PARENTHESIS, new RightParenthesisParser());
        put(FINISH, new EndOfExpressionParser());
    }};

    @Override
    public boolean isAcceptableState(CalculationContext context, State state) throws CalculationException {
        final CalculationParser parser = parsers.get(state);
        if (parser == null) {
            throw new IllegalStateException("Parser not found for state: " + state);
        }
        final Token token = parser.parse(context);
        if (token == null) {
            return false;
        }
        TokenAcceptor acceptor = new TokenAcceptor(context.getStack());
        token.accept(acceptor);
        return true;
    }
}