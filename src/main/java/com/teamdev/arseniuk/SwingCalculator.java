package com.teamdev.arseniuk;

import com.teamdev.arseniuk.impl.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingCalculator extends JFrame {

    private static final String OPEN_IN_CONSOLE = "-c";
    private final Calculator calculator = new Calculator();
    private final JLabel lbExpression;
    private final JLabel lbResult;
    private final JTextArea taExpression;
    private final JTextArea taResult;
    private final JButton btnCalculate;

    public SwingCalculator() {
        lbExpression = new JLabel("Expression");
        lbResult = new JLabel("Result");
        taExpression = new JTextArea(10, 60);
        taResult = new JTextArea(3, 60);
        btnCalculate = new JButton("Calculate");

        prepareUI();
    }

    private void prepareUI() {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        btnCalculate.addActionListener(onCalculatePressed);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createParallelGroup()
                        .addComponent(lbExpression)
                        .addComponent(taExpression)
                        .addComponent(btnCalculate)
                        .addComponent(lbResult)
                        .addComponent(taResult)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                        .addComponent(lbExpression)
                        .addComponent(taExpression)
                        .addComponent(btnCalculate)
                        .addComponent(lbResult)
                        .addComponent(taResult)
        );

        pack();

        setTitle("Calculator");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private ActionListener onCalculatePressed = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {

            try {
                final double result = calculator.calculate(taExpression.getText());
                taResult.setText(String.valueOf(result));

            } catch (CalculationException e) {
                taResult.setText(e.getMessage());
                taExpression.requestFocusInWindow();
                taExpression.setCaretPosition(e.getCursorPosition());
            }
        }
    };

    public static void main(String[] args) {

        if (args.length != 0 && args[0].equals(OPEN_IN_CONSOLE)) {
            ConsoleCalculator consoleCalculator = new ConsoleCalculator();
            consoleCalculator.main(new String[]{});
        } else {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    SwingCalculator calculator = new SwingCalculator();
                    calculator.setVisible(true);
                }
            });
        }
    }
}
