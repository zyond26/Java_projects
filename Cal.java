import java.awt.*;
import java.awt.event.*;

public class Cal extends Frame {
    TextField t1, t2, result;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide;

    Cal() {
        setTitle("Simple Calculator");
        Panel p = new Panel();
        p.setLayout(new GridLayout(5, 2));

        t1 = new TextField(10);
        p.add(new Label("Number 1:"));
        p.add(t1);

        t2 = new TextField(10);
        p.add(new Label("Number 2:"));
        p.add(t2);

        result = new TextField(10);
        result.setEditable(false); // Prevent manual editing of result field
        p.add(new Label("Result:"));
        p.add(result);

        btnAdd = new Button("+");
        btnSubtract = new Button("-");
        btnMultiply = new Button("*");
        btnDivide = new Button("/");

        p.add(btnAdd);
        p.add(btnSubtract);
        p.add(btnMultiply);
        p.add(btnDivide);

        // Action listeners for buttons
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('+');
            }
        });

        btnSubtract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('-');
            }
        });

        btnMultiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('*');
            }
        });

        btnDivide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('/');
            }
        });

        add(p);
        setSize(300, 200);
        setVisible(true);
    }

    // Method to perform calculation
    private void calculate(char operator) {
        try {
            double num1 = Double.parseDouble(t1.getText());
            double num2 = Double.parseDouble(t2.getText());
            double resultValue = 0;

            switch (operator) {
                case '+':
                    resultValue = num1 + num2;
                    break;
                case '-':
                    resultValue = num1 - num2;
                    break;
                case '*':
                    resultValue = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        resultValue = num1 / num2;
                    } else {
                        result.setText("Error: Division by zero");
                        return;
                    }
                    break;
            }

            result.setText(Double.toString(resultValue));
        } catch (NumberFormatException ex) {
            result.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        new Cal();
    }
}
