import java.awt.Button;
import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class bt_08 {
    public static void main(String[] args) {
        Frame f = new Frame("Example");
        f.setSize(200, 300);

        // Tạo các checkbox
        Checkbox checkbox1 = new Checkbox("Option 1");
        Checkbox checkbox2 = new Checkbox("Option 2");
        Checkbox checkbox = new Checkbox("check me");
        // Thêm checkbox vào frame
        f.add(checkbox1);
        f.add(checkbox2);
        f.add(checkbox);
        f.add(new Button("Save"));
        f.add(new Button("choose"));
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("clicked on X");
                f.dispose();
            }
        });

        f.setLayout(new FlowLayout()); // Chọn layout (ví dụ: FlowLayout)

        f.setVisible(true);
        System.out.println("ended");
    }
}
