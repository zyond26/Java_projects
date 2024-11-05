package BaiTapppppp;
/*Bài tập 29.
Triển khai Dispatcher với Nhập Liệu từ Bàn Phím

Yêu cầu:

Tạo một lớp Java trong lớp này, định nghĩa một biến static kiểu String có tên currentCommand để 
lưu trữ lệnh hiện tại.
Triển khai một phương thức static có tên inputCommand():
Sử dụng Scanner để nhận input từ người dùng.
Yêu cầu người dùng nhập lệnh (A, B, C hoặc EXIT).
Lưu lệnh đã nhập (chuyển thành chữ hoa) vào biến currentCommand.
Triển khai một phương thức static có tên dispatch():
Sử dụng cấu trúc switch-case để xử lý currentCommand.
Nếu lệnh là A, B, hoặc C, in ra thông báo tương ứng.
Nếu lệnh là EXIT, in thông báo kết thúc và thoát chương trình.
Với các lệnh không hợp lệ, in ra thông báo lỗi.

Trong phương thức main():
Tạo một vòng lặp vô hạn.
Trong mỗi lần lặp, gọi inputCommand() và sau đó gọi dispatch(). */

import java.util.Scanner;

public class Bai29 {
    // Biến toàn cục để lưu lệnh hiện tại
    private static String currentCommand = "";

    // Hàm để nhập lệnh từ bàn phím
    public static void inputCommand() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nhap lenh (A, B, C hoac EXIT de thoat): ");
            currentCommand = scanner.nextLine().toUpperCase();
        }
    }

    // Hàm dispatcher
    public static void dispatch() {
        switch (currentCommand) {
            case "A":
                System.out.println("Thuc thi lenh A");
                break;
            case "B":
                System.out.println("Thuc thi lenh B");
                break;
            case "C":
                System.out.println("Thuc thi lenh C");
                break;
            case "EXIT":
                System.out.println("Ket thuc chuong trinh");
                System.exit(0);
            default:
                System.out.println("Lenh khong hop le");
                break;
        }
    }

    public static void main(String[] args) {
        while (true) {
            inputCommand();
            dispatch();
        }
    }
}