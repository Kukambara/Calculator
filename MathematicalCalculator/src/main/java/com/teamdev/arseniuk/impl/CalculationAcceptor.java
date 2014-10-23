package com.teamdev.arseniuk.impl;

import com.teamdev.arseniuk.CalculationParser;
import com.teamdev.arseniuk.Command;
import com.teamdev.arseniuk.StateAcceptor;
import com.teamdev.arseniuk.impl.parser.NumberParser;

import java.util.HashMap;

import static com.teamdev.arseniuk.impl.State.NUMBER;

public class CalculationAcceptor implements StateAcceptor<State, CalculationContext> {

    private final HashMap<State, CalculationParser> parsers = new HashMap<State, CalculationParser>() {{
        put(NUMBER, new NumberParser());
    }};

    @Override
    public boolean isAcceptableState(CalculationContext context, State state) {
        final CalculationParser parser = parsers.get(state);
        if (parser == null) {
            throw new IllegalStateException("Parser not found for state: " + state);
        }
        final Command command = parsers.get(state).parse(context);
        if (command == null) {
            return false;
        }
        command.calculate(context.getStack());
        return true;
    }
}
