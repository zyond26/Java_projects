import java.awt.*;
import java.awt.event.*;

public class MyApp extends Frame {
    TextField t1, t2, result, operator;

    MyApp() {
        Frame f = new Frame();
        Panel p = new Panel();
        p.setLayout(new GridLayout(6, 2));
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                f.dispose(); // Close the window
            }
        });
        t1 = new TextField(6);
        p.add(new Label("var t1"));
        p.add(t1);
        t2 = new TextField(6);
        p.add(new Label("var t2"));
        p.add(t2);
        operator = new TextField(6);
        p.add(new Label("operator"));
        p.add(operator);
        result = new TextField(6);
        p.add(new Label("Result"));
        p.add(result);
        Button btn = new Button("Calculator");
        p.add(btn);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate(); // Call the calculate method when the button is clicked
            }
        });
        f.setSize(300, 400);
        f.add(p);
        f.setVisible(true); // Add this line to make the frame visible
    }

    // Method to perform calculation
    private void calculate() {
        try {
            // Get the values from text fields
            double num1 = Double.parseDouble(t1.getText());
            double num2 = Double.parseDouble(t2.getText());
            String op = operator.getText().trim(); // Get the operator and remove leading/trailing spaces
            double res;
            // Perform calculation based on the operator
            switch (op) {
                case "+":
                    res = num1 + num2;
                    break;
                case "-":
                    res = num1 - num2;
                    break;
                case "*":
                    res = num1 * num2;
                    break;
                case "/":
                    // Check if denominator is not zero
                    if (num2 != 0)
                        res = num1 / num2;
                    else {
                        result.setText("Division by zero!");
                        return;
                    }
                    break;
                default:
                    result.setText("Invalid operator");
                    return;
            }

            // Display the result
            result.setText(Double.toString(res));
        } catch (NumberFormatException ex) {
            // Handle the case where input is not a valid number
            result.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        System.out.println("End");
    }
}
