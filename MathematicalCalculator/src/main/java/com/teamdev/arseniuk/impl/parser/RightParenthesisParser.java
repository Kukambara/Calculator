package com.teamdev.arseniuk.impl.parser;

import com.teamdev.arseniuk.CalculationParser;
import com.teamdev.arseniuk.Parenthesis;
import com.teamdev.arseniuk.Token;
import com.teamdev.arseniuk.impl.ExpressionReader;
import com.teamdev.arseniuk.impl.operation.RightParenthesis;

public class RightParenthesisParser implements CalculationParser {

    @Override
    public Token parse(ExpressionReader reader) {
        final String expression = reader.getRemainExpression();
        final Token token;
        if (expression.isEmpty()) {
            return null;
        }
        if (expression.charAt(0) == Parenthesis.RIGHT_PARENTHESIS.getSymbol()) {
            token = new RightParenthesis(reader.getIndex());
            reader.incrementIndex(1);
            return token;
        }
        return null;
    }
}