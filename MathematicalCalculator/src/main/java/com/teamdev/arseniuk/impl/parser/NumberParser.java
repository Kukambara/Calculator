package com.teamdev.arseniuk.impl.parser;

import com.teamdev.arseniuk.CalculationParser;
import com.teamdev.arseniuk.Token;
import com.teamdev.arseniuk.impl.CalculationContext;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

public class NumberParser implements CalculationParser {
    private final NumberFormat numberFormat = DecimalFormat.getNumberInstance(Locale.US);

    @Override
    public Token parse(CalculationContext context) {

        final String mathExpression = context.getExpression();
        int index = context.getExpressionParsingIndex();

        while (index < mathExpression.length() && Character.isSpaceChar(mathExpression.charAt(index))) {
            index++;
        }


        final ParsePosition parsePosition = new ParsePosition(index);
        final Number number = numberFormat.parse(mathExpression, parsePosition);
        if (parsePosition.getErrorIndex() != -1) {
            return null;
        }

        context.setExpressionParsingIndex(parsePosition.getIndex());
        context.getStack().getOperandStack().push(number.doubleValue());

        return new com.teamdev.arseniuk.impl.Number();
    }
}
