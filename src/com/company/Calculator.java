package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JFrame frame = new JFrame("Floppaculator");
    BPanel panel = new BPanel();
    private JTextField NumField1 = new JTextField();
    private JTextField NumField2 = new JTextField();
    private JTextField NumField3 = new JTextField();
    private JTextField ResultField = new JTextField();
    private JButton plus = new JButton("+");
    private JButton minus = new JButton("-");
    private JButton equals = new JButton("=");
    private JButton cancel = new JButton("C");
    private int num1, num2, num3, result;
    ActionButton b = new ActionButton();

    public Calculator() {
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        panel.setLayout(null);
        AddTextField();
        AddButton();
    }

    private void AddButton(){
        panel.add(plus);
        plus.setLocation(380, 360);
        plus.setSize(48, 48);
        plus.setFont(new Font("Bahnschrift", Font.PLAIN, 28));
        plus.addActionListener(b);
        panel.add(minus);
        minus.setLocation(380, 410);
        minus.setSize(48, 48);
        minus.setFont(new Font("Bahnschrift", Font.PLAIN, 28));
        minus.addActionListener(b);
        panel.add(equals);
        equals.setLocation(430, 360);
        equals.setSize(48, 48);
        equals.setFont(new Font("Bahnschrift", Font.PLAIN, 28));
        equals.addActionListener(b);
        panel.add(cancel);
        cancel.setLocation(430, 410);
        cancel.setSize(48, 48);
        cancel.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
        cancel.addActionListener(b);
    }

    private void AddTextField(){
        panel.add(NumField1);
        NumField1.setLocation(10, 300);
        NumField1.setSize(70, 28);
        NumField1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        NumField1.addActionListener(b);
        panel.add(NumField2);
        NumField2.setLocation(10, 330);
        NumField2.setSize(70, 28);
        NumField2.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        NumField2.addActionListener(b);
        panel.add(NumField3);
        NumField3.setLocation(10, 360);
        NumField3.setSize(70, 28);
        NumField3.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        NumField3.addActionListener(b);
        panel.add(ResultField);
        ResultField.setLocation(10, 410);
        ResultField.setSize(150, 38);
        ResultField.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
        ResultField.addActionListener(b);
        ResultField.setEditable(false);
    }
    private class ActionButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            /*
            13.02.22 19:49  Возможно, тут что-то поменяется, например, можно будет находить сумму
                            или разницу двух чисел (а может и вообще одного 0_0 (Шутка)).
            13.02.22 20.25  Вышла обнова для Floppaculator. Теперь можно находить сумму или разницу
                            двух чисел.
            */
            if (e.getSource() == plus){
                if (NumField1.getText().equals("")){
                    num2 = Integer.parseInt(NumField2.getText());
                    num3 = Integer.parseInt(NumField3.getText());
                    result = num2 + num3;
                }
                if (NumField2.getText().equals("")){
                    num1 = Integer.parseInt(NumField1.getText());
                    num3 = Integer.parseInt(NumField3.getText());
                    result = num1 + num3;
                }
                if (NumField3.getText().equals("")){
                    num1 = Integer.parseInt(NumField1.getText());
                    num2 = Integer.parseInt(NumField2.getText());
                    result = num1 + num2;
                }
                else{
                    num1 = Integer.parseInt(NumField1.getText());
                    num2 = Integer.parseInt(NumField2.getText());
                    num3 = Integer.parseInt(NumField3.getText());
                    result = num1 + num2 + num3;
                }
            }

            if (e.getSource() == minus){
                if (NumField1.getText().equals("")){
                    num2 = Integer.parseInt(NumField2.getText());
                    num3 = Integer.parseInt(NumField3.getText());
                    result = num2 - num3;
                }
                if (NumField2.getText().equals("")){
                    num1 = Integer.parseInt(NumField1.getText());
                    num3 = Integer.parseInt(NumField3.getText());
                    result = num1 - num3;
                }
                if (NumField3.getText().equals("")){
                    num1 = Integer.parseInt(NumField1.getText());
                    num2 = Integer.parseInt(NumField2.getText());
                    result = num1 - num2;
                }
                else{
                    num1 = Integer.parseInt(NumField1.getText());
                    num2 = Integer.parseInt(NumField2.getText());
                    num3 = Integer.parseInt(NumField3.getText());
                    result = num1 - num2 - num3;
                }
            }

            if (e.getSource() == equals){
                ResultField.setText("" + result);
                NumField1.setText("");
                NumField2.setText("");
                NumField3.setText("");
            }

            if (e.getSource() == cancel){
                ResultField.setText("");
                NumField1.setText("");
                NumField2.setText("");
                NumField3.setText("");
            }
        }
    }
}