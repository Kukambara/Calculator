package com.teamdev.arseniuk.impl.parser;

import com.teamdev.arseniuk.CalculationParser;
import com.teamdev.arseniuk.Token;
import com.teamdev.arseniuk.impl.CalculationStack;
import com.teamdev.arseniuk.impl.ExpressionReader;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

public class NumberParser implements CalculationParser {
    private final NumberFormat numberFormat = DecimalFormat.getNumberInstance(Locale.US);

    @Override
    public Token parse(ExpressionReader reader) {
        final String mathExpression = reader.getExpression();
        reader.skipWhitespaces();
        int index = reader.getIndex();


        final ParsePosition parsePosition = new ParsePosition(index);
        final Number number = numberFormat.parse(mathExpression, parsePosition);
        if (parsePosition.getErrorIndex() != -1) {
            return null;
        }

        reader.setIndex(parsePosition.getIndex());

        return new Token(index) {
            @Override
            public void execute(CalculationStack stack) {
                stack.pushOperand(number.doubleValue());
            }
        };
    }
}
