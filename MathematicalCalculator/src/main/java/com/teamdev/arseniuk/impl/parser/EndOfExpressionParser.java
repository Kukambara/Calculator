package com.teamdev.arseniuk.impl.parser;

import com.teamdev.arseniuk.CalculationParser;
import com.teamdev.arseniuk.Token;
import com.teamdev.arseniuk.impl.EndOfExpression;
import com.teamdev.arseniuk.impl.ExpressionReader;

public class EndOfExpressionParser implements CalculationParser {

    @Override
    public Token parse(ExpressionReader reader) {
        if (!reader.isEnd()) {
            return null;
        }
        return new EndOfExpression(reader.getIndex());
    }
}
