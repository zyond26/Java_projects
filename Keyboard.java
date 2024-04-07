import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Keyboard extends JFrame {
    private JTextArea textArea;

    public Keyboard() {
        setTitle("Virtual Keyboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Khởi tạo JTextArea để hiển thị văn bản được nhập từ bàn phím ảo
        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Tạo bàn phím ảo
        JPanel keyboardPanel = new JPanel(new GridLayout(4, 10));

        // Dãy ký tự tiếng Việt
        String[] vietnameseChars = {"a", "ă", "â", "e", "ê", "i", "o", "ô", "ơ", "u", "ư", "y",
                "d", "đ", "b", "c", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s",
                "t", "v", "x", "z"};

        // Thêm các nút cho bàn phím ảo
        for (String character : vietnameseChars) {
            JButton button = new JButton(character);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.append(button.getText());
                }
            });
            keyboardPanel.add(button);
        }

        add(keyboardPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); // Hiển thị cửa sổ ở giữa màn hình
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Keyboard().setVisible(true);
            }
        });
    }
}
