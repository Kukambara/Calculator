package com.teamdev.arseniuk;

import com.teamdev.arseniuk.impl.EndOfExpression;
import com.teamdev.arseniuk.impl.operation.*;

public interface Visitor {

    void visit(Addition command) throws CalculationException;

    void visit(Division command) throws CalculationException;

    void visit(Involution command) throws CalculationException;

    void visit(LeftParenthesis command);

    void visit(Multiplication command) throws CalculationException;

    void visit(RightParenthesis command) throws CalculationException;

    void visit(Subtraction command) throws CalculationException;

    void visit(EndOfExpression command) throws CalculationException;
}
