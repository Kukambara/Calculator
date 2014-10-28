package com.teamdev.arseniuk;

import com.teamdev.arseniuk.impl.CalculationStack;

public interface Token {
    public void execute(CalculationStack stack);

    public void accept(Visitor visitor) throws CalculationException;
}
