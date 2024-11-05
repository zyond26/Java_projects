package thread;

/*Bài tập 40. Dạng Thread.1 
Viết một chương trình Java có tên là "Main" thực hiện các chức năng sau:

Yêu cầu chung:
a. Viết hàm static có 1 vòng lặp, trong thân của vòng lặp, nhập vào xâu kí tự, 
   nếu nhập xâu "#" thì kết thúc vòng lặp và hàm thực hiện xong.
b. Đặt hàm vào luồng.

Yêu cầu chi tiết:
a. Tạo một phương thức static có tên là "nhapXau" thực hiện các nhiệm vụ:
Sử dụng Scanner để nhập các xâu ký tự từ bàn phím.
In ra thông báo yêu cầu người dùng nhập xâu ký tự.
Sử dụng vòng lặp để liên tục nhận input từ người dùng.
Nếu người dùng nhập xâu "#", kết thúc vòng lặp và in ra thông báo kết thúc nhập.
Với mỗi xâu nhập vào (trừ "#"), in ra màn hình xâu đó.
b. Trong phương thức main:
Tạo một luồng mới, sử dụng phương thức nhapXau làm nhiệm vụ của luồng.
Khởi động luồng.
Sử dụng phương thức join() để đợi luồng kết thúc.
Xử lý ngoại lệ InterruptedException nếu có.
In ra thông báo "Chương trình kết thúc." sau khi luồng hoàn thành.
Chương trình phải đảm bảo đóng Scanner sau khi sử dụng xong. */

// Giải:

import java.util.Scanner;

public class bai40 {
    public static void main(String[] args) {
        // Tạo và khởi động luồng
        Thread thread = new Thread(bai40::nhapXau);
        thread.start();

        try {
            // Đợi luồng kết thúc
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Chương trình kết thúc.");
    }

    public static void nhapXau() {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Nhập các xâu kí tự (nhập '#' để kết thúc):");

        while (true) {
            input = scanner.nextLine();

            if (input.equals("#")) {
                System.out.println("Kết thúc nhập.");
                break;
            }

            System.out.println("Bạn đã nhập: " + input);
        }

        scanner.close();
    }
}
