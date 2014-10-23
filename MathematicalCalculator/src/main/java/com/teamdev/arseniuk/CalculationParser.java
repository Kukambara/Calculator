package com.teamdev.arseniuk;

import com.teamdev.arseniuk.impl.CalculationContext;

public interface CalculationParser {
    public Command parse(CalculationContext context);
}
