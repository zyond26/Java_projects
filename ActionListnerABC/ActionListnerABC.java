package ActionListnerABC;

// =========================
// ActionListenner
// ============================
import java.awt.Frame;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Checkbox;

public class ActionListnerABC extends Frame implements ActionListener {
    private Button myButton;
    private Button myExitButton;
    private Checkbox ckb;

    public ActionListnerABC() {
        // Set up the frame
        setLayout(new FlowLayout());
        setTitle("ActionListener Example");
        setSize(300, 200);
        // Create a button
        myButton = new Button("Click Me");
        // Add ActionListener to the button
        myButton.addActionListener(this);

        // Add button to the frame
        add(myButton);
        myExitButton = new Button("Exit");
        myExitButton.addActionListener(this);
        add(myExitButton);
        // Make the frame visible
        addWindowListener(new WindowAdapter() {
//            @Override
            public void windowClosing(WindowEvent e) {
                // Exit the program
                System.exit(0);
            }
        });
        
        ckb = new Checkbox("my check box");
        add(ckb);
//        ckb.addActionListener(this);
        setVisible(true);
    }

    // Implement actionPerformed method from ActionListener interface
    public void actionPerformed(ActionEvent e) {
        // Handle button click event
        if (e.getSource() == myButton) {
            System.out.println("Button clicked!");
            System.out.println("CKB " + ckb.getLabel());
            System.out.println("State " + ckb.getState());
        }
        else if (e.getSource() == myExitButton) {
            System.out.println("Exit program!");
            System.exit(0);
        }

    }


    public static void main(String[] args) {
        new ActionListnerABC();
    }
}
