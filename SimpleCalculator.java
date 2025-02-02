import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(5, 2));

        JLabel label1 = new JLabel("Number 1:");
        JTextField text1 = new JTextField();
        JLabel label2 = new JLabel("Number 2:");
        JTextField text2 = new JTextField();
        JLabel resultLabel = new JLabel("Result:");
        JTextField result = new JTextField();
        result.setEditable(false);

        JButton addButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton mulButton = new JButton("*");
        JButton divButton = new JButton("/");

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(text1.getText());
                    double num2 = Double.parseDouble(text2.getText());
                    double res = 0;

                    if (e.getSource() == addButton) {
                        res = num1 + num2;
                    } else if (e.getSource() == subButton) {
                        res = num1 - num2;
                    } else if (e.getSource() == mulButton) {
                        res = num1 * num2;
                    } else if (e.getSource() == divButton) {
                        if (num2 != 0) {
                            res = num1 / num2;
                        } else {
                            JOptionPane.showMessageDialog(frame, "Cannot divide by zero");
                            return;
                        }
                    }
                    result.setText(String.valueOf(res));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input, please enter numbers");
                }
            }
        };

        addButton.addActionListener(actionListener);
        subButton.addActionListener(actionListener);
        mulButton.addActionListener(actionListener);
        divButton.addActionListener(actionListener);

        frame.add(label1);
        frame.add(text1);
        frame.add(label2);
        frame.add(text2);
        frame.add(addButton);
        frame.add(subButton);
        frame.add(mulButton);
        frame.add(divButton);
        frame.add(resultLabel);
        frame.add(result);

        frame.setVisible(true);
    }
}
