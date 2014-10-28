package com.teamdev.arseniuk;

import com.teamdev.arseniuk.impl.CalculationStack;
import com.teamdev.arseniuk.impl.EndOfExpression;
import com.teamdev.arseniuk.impl.operation.*;

public class TokenAcceptor implements Visitor {

    private final CalculationStack stack;

    public TokenAcceptor(CalculationStack stack) {
        this.stack = stack;
    }

    @Override
    public void visit(Addition command) throws CalculationException {
        addCommand(command);
    }

    @Override
    public void visit(Division command) throws CalculationException {
        addCommand(command);
    }

    @Override
    public void visit(Involution command) throws CalculationException {
        addCommand(command);
    }

    @Override
    public void visit(LeftParenthesis command) {
        pushOperation(command);
        stack.incrementParenthesis();
    }

    @Override
    public void visit(Multiplication command) throws CalculationException {
        addCommand(command);
    }

    @Override
    public void visit(RightParenthesis command) throws CalculationException {
        pushOperation(command);
        stack.decrementParenthesis();
        CommandExecutor executor = new CommandExecutor(stack);
        command.accept(executor);
    }

    @Override
    public void visit(Subtraction command) throws CalculationException {
        addCommand(command);
    }

    @Override
    public void visit(EndOfExpression command) throws CalculationException {
        addCommand(command);
        if (stack.getOpenedParenthesisCount() < 0) {
            throw new CalculationException("Missing left parenthesis in expression", 0);
        } else if (stack.getOpenedParenthesisCount() > 0) {
            throw new CalculationException("Missing right parenthesis in expression", 0);
        }
        CommandExecutor executor = new CommandExecutor(stack);
        command.accept(executor);
    }

    private void addCommand(Command newCommand) throws CalculationException {
        final Command lastCommand = peekOperation();
        if (lastCommand != null && lastCommand.getPriority() >= newCommand.getPriority()) {
            CommandExecutor executor = new CommandExecutor(stack);
            lastCommand.accept(executor);
        }
        pushOperation(newCommand);
    }


    private Command peekOperation() {
        if (!stack.getOperationStack().isEmpty()) {
            return stack.getOperationStack().peek();
        }
        return null;
    }


    private void pushOperation(Command command) {
        stack.getOperationStack().push(command);
    }
}
