package com.teamdev.arseniuk;

import com.teamdev.arseniuk.impl.CalculationStack;
import com.teamdev.arseniuk.impl.EndOfExpression;
import com.teamdev.arseniuk.impl.operation.*;

public class CommandExecutor implements Visitor {
    public static final int MIN_OPERAND_COUNT = 2;
    private final CalculationStack stack;

    public CommandExecutor(CalculationStack stack) {
        this.stack = stack;
    }

    @Override
    public void visit(Addition command) throws CalculationException {
        executeCommand(command);
    }

    @Override
    public void visit(Division command) throws CalculationException {
        executeCommand(command);
    }

    @Override
    public void visit(Involution command) throws CalculationException {
        executeCommand(command);
    }

    @Override
    public void visit(LeftParenthesis command) {
        popOperation();
    }

    @Override
    public void visit(Multiplication command) throws CalculationException {
        executeCommand(command);
    }

    @Override
    public void visit(RightParenthesis command) throws CalculationException {
        popOperation();
        Command lastCommand = peekOperation();
        while (lastCommand != null) {
            lastCommand.accept(this);
            if (lastCommand.getClass() == LeftParenthesis.class)
                return;
            lastCommand = peekOperation();
            if (lastCommand == null) {
                throw new CalculationException("Left parenthesis has not been bound.", 0);
            }
        }
        popOperation();
    }

    @Override
    public void visit(Subtraction command) throws CalculationException {
        executeCommand(command);
    }

    @Override
    public void visit(EndOfExpression command) throws CalculationException {
        popOperation();
        while (!stack.getOperationStack().isEmpty()) {
            peekOperation().accept(this);
        }
    }

    private void executeCommand(Command command) throws CalculationException {
        if (isExecutableOperation()) {
            executeSecondLastCommand();
            command.execute(stack);
            popOperation();
        }
    }

    private void executeSecondLastCommand() throws CalculationException {
        final Command lastCommand = popOperation();
        final Command secondLastCommand = peekOperation();
        if (secondLastCommand != null && secondLastCommand.getPriority() >= lastCommand.getPriority()) {
            secondLastCommand.accept(this);
        }
        pushOperation(lastCommand);
    }

    private Command peekOperation() {
        if (!stack.getOperationStack().isEmpty()) {
            return stack.getOperationStack().peek();
        }
        return null;
    }

    private Command popOperation() {
        if (!stack.getOperationStack().isEmpty()) {
            return stack.getOperationStack().pop();
        }
        return null;
    }

    private void pushOperation(Command command) {
        stack.getOperationStack().push(command);
    }

    private boolean isExecutableOperation() {
        return stack.getOperandStack().size() >= MIN_OPERAND_COUNT;
    }
}
