package com.teamdev.arseniuk.impl;

public class ExpressionReader {
    private final String expression;
    private int index;

    public ExpressionReader(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public String getRemainExpression() {
        skipWhitespaces();
        return expression.substring(index);
    }

    public void skipWhitespaces() {
        while (index < expression.length() && Character.isWhitespace(expression.charAt(index))) {
            index++;
        }
    }

    public boolean isEnd() {
        return index >= expression.length();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void incrementIndex(int index) {
        this.index += index;
    }

}
