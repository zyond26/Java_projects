import java.awt.Frame; 
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Frames {
    public static void main(String arg[]) { 
        final Frame f = new Frame("Example"); 
        f.setSize(300,400);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // Implement actions to be performed when the window is closing
                System.out.println("Clicked on X");
                f.dispose(); // Close the window
            }
        });
        f.setVisible(true); 
    } 
}
