import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ExamplePannel extends Frame{
    ExamplePannel(String m){
        super("ExamplePanel: " +m);
        setSize(100,150);
        Panel p = new Panel();
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JButton("Button 1"));
        panel.add(new JButton("Button 2"));
        panel.add(new JButton("Button 3"));
        panel.add(new JButton("Button 4"));
        panel.add(new JButton("Button 5"));
        panel.add(new JButton("Button 6"));
        add(p);
        p.add(panel);
        p.add(new Button("Save"));
        p.add(new Checkbox("Save settings"));
        setVisible(true);
    }
    public static void main(String[] args) {
        new ExamplePannel("Inserting Components");
        
    }
}
