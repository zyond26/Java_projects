import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {
    TextArea txt;
    String currentText = "";
    double result = 0;
    String operator = "";
    String expression = "";

    public static void main(String arg[]) {
        new Calculator("Calculator");
    }

    Calculator(String m) {
        super("Dieu's " + m);
        setSize(340, 280);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        Panel p = new Panel();
        p.setLayout(new BorderLayout());
        txt = new TextArea();
        txt.setEditable(false); // Make TextArea read-only
        p.add("North", txt);
        Panel subPanel = new Panel();
        subPanel.setLayout(new GridLayout(4, 4));

        for (int i = 9; i >= 0; i--) {
            Button btn = new Button("" + i);
            btn.addActionListener(this);
            subPanel.add(btn);
        }
        Button btnClear = new Button("Clear");
        btnClear.addActionListener(this);
        subPanel.add(btnClear);
        
        String operators[] = {"+", "-", "*", "/", "="};
        for (String op : operators) {
            Button btn = new Button(op);
            btn.addActionListener(this);
            subPanel.add(btn);
        }
        p.add("South", subPanel);
        add(p);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Clear":
                currentText = "";
                expression = "";
                break;
            case "=":
                calculateResult();
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                setOperator(command);
                break;
            default:
                currentText += command;
                expression += command;
        }
        txt.setText(expression);
    }

    private void setOperator(String op) {
        if (!currentText.isEmpty()) {
            expression += op;
            result = Double.parseDouble(currentText);
            operator = op;
            currentText = "";
        }
    }

    private void calculateResult() {
        if (!currentText.isEmpty() && !operator.isEmpty()) {
            double secondOperand = Double.parseDouble(currentText);
            switch (operator) {
                case "+":
                    result += secondOperand;
                    break;
                case "-":
                    result -= secondOperand;
                    break;
                case "*":
                    result *= secondOperand;
                    break;
                case "/":
                    if (secondOperand != 0)
                        result /= secondOperand;
                    else
                        txt.setText("Error: Division by zero");
                    break;
            }
            currentText = Double.toString(result);
            expression += "=" + currentText;
            operator = "";
        }
    }
}
