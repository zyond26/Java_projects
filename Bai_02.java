// Bài 2: Cho 1 file text có nội dung như sau, (các em tự tạo file text để làm).
// Chao mung cac ban
// Den voi truong
// CMC
// Hãy viết 1 hàm để đếm xem trong 1 file có bao nhiêu chữ, ví dụ như file trên thì kết quả cần ra là 8.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Bai_02 {
    public static void main(String[] args) {
        String fileName = "btap.txt"; // Đặt đường dẫn của tệp văn bản của bạn ở đây
        
        try {
            int wordCount = countWords(fileName);
            System.out.println("So luong tu trong tep la: " + wordCount);
        } catch (IOException e) {
            System.err.println("loi khi doc tep: " + e.getMessage());
        }
    }

    public static int countWords(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int wordCount = 0;
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String[] words = line.split("\\s+"); // Tách từ trong dòng sử dụng khoảng trắng làm dấu phân cách
            wordCount += words.length;
        }

        bufferedReader.close();
        return wordCount;
    }
}
