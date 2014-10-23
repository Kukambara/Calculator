package com.teamdev.arseniuk.impl.parser;

import com.teamdev.arseniuk.CalculationParser;
import com.teamdev.arseniuk.Command;
import com.teamdev.arseniuk.impl.CalculationContext;
import com.teamdev.arseniuk.impl.CalculationStack;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

public class NumberParser implements CalculationParser {
    private final NumberFormat numberFormat = DecimalFormat.getNumberInstance(Locale.US);

    @Override
    public Command parse(CalculationContext context) {

        final String mathExpression = context.getExpression();
        final int index = context.getExpressionParsingIndex();

        final ParsePosition parsePosition = new ParsePosition(index);
        final Number number = numberFormat.parse(mathExpression, parsePosition);
        if (parsePosition.getErrorIndex() != -1) {
            return null;
        }

        context.setExpressionParsingIndex(parsePosition.getIndex());

        return new Command() {
            @Override
            public void calculate(CalculationStack stack) {
                stack.getOperandStack().push(number.doubleValue());
            }
        };
    }
}
