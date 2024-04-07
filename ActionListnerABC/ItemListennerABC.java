package ActionListnerABC;

import java.awt.Frame;
import java.awt.Checkbox;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemListennerABC  extends Frame implements ItemListener {
    private Checkbox myCheckbox;

    public ItemListennerABC() {
        // Set up the frame
        setTitle("ItemListener Example");
        setSize(300, 200);

        // Create a checkbox
        myCheckbox = new Checkbox("Enable Feature");

        // Add ItemListener to the checkbox
        myCheckbox.addItemListener(this);

        // Add checkbox to the frame
        add(myCheckbox);

        // Make the frame visible
        setVisible(true);
    }

    // Implement itemStateChanged method from ItemListener interface
    public void itemStateChanged(ItemEvent e) {
        // Handle checkbox state change event
        if (e.getItemSelectable() == myCheckbox) {
            if (myCheckbox.getState()) {
                System.out.println("Feature enabled");
            } else {
                System.out.println("Feature disabled");
            }
        }
    }

    public static void main(String[] args) {
        new ItemListennerABC();
    }
}
