package com.teamdev.arseniuk;

import com.teamdev.arseniuk.impl.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SwingCalculator extends JFrame {

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

        JButton executeButton = new JButton("Console");
        executeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Runtime rt = Runtime.getRuntime();
                    String[] cmd = {"java", "-cp", ConsoleCalculator.class.getProtectionDomain().getCodeSource().getLocation().getPath(), ConsoleCalculator.class.getCanonicalName()};
                    Process p = new ProcessBuilder(cmd).redirectError(ProcessBuilder.Redirect.INHERIT).redirectOutput(ProcessBuilder.Redirect.INHERIT).start();
                    p.waitFor();


                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });

        gl.setHorizontalGroup(gl.createParallelGroup()
                        .addComponent(lbExpression)
                        .addComponent(taExpression)
                        .addComponent(btnCalculate)
                        .addComponent(lbResult)
                        .addComponent(taResult)
                        .addComponent(executeButton)

        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                        .addComponent(lbExpression)
                        .addComponent(taExpression)
                        .addComponent(btnCalculate)
                        .addComponent(lbResult)
                        .addComponent(taResult)
                        .addComponent(executeButton)
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

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SwingCalculator calculator = new SwingCalculator();
                calculator.setVisible(true);
            }
        });
    }
}
