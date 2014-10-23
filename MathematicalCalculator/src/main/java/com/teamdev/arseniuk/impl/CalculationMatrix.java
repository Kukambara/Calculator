package com.teamdev.arseniuk.impl;

import com.teamdev.arseniuk.TransitionMatrix;

import java.util.HashMap;
import java.util.Set;

import static com.teamdev.arseniuk.impl.State.*;
import static java.util.EnumSet.noneOf;
import static java.util.EnumSet.of;

public class CalculationMatrix implements TransitionMatrix<State> {
    private final HashMap<State, Set<State>> matrix = new HashMap<State, Set<State>>() {{
        put(START, of(NUMBER));
        put(NUMBER, of(BINARY_OPERATION, FINISH));
        put(BINARY_OPERATION, of(NUMBER));
        put(FINISH, noneOf(State.class));
    }};

    @Override
    public State getStartState() {
        return START;
    }

    @Override
    public State getFinishState() {
        return FINISH;
    }

    @Override
    public Set<State> getPossibleStates(State state) {
        return matrix.get(state);
    }
}
