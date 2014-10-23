package com.teamdev.arseniuk;

import com.teamdev.arseniuk.impl.CalculationStack;

public interface Command {
    public void calculate(CalculationStack stack);
}
