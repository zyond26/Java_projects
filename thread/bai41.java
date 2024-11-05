package thread;
/*Bài tập 41. Dạng Thread.1 
Viết một chương trình Java có tên là "Main" thực hiện các chức năng sau:

Yêu cầu chung:
a. Viết hàm static có 1 vòng lặp, trong thân của vòng lặp, nhập vào 1 số nguyên dương, 
   nếu nhập số chia hết cho 102024 thì kết thúc vòng lặp trái lại tính tổng các số từ 1 đến n và hiển thị.
b. Đặt hàm vào luồng. */

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class bai41 {
    public static void calculateSum() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Nhập vào một số nguyên dương (hoặc số chia hết cho 102024 để thoát): ");
            int n = scanner.nextInt();
            if (n % 102024 == 0) {
                System.out.println("Số bạn nhập chia hết cho 102024. Kết thúc chương trình.");
                break;
            } else {
                int sum = 0;
                for (int i = 1; i <= n; i++) {
                    sum += i;
                }
                System.out.println("Tổng các số từ 1 đến " + n + " là: " + sum);
            }
        }
        scanner.close();
    }

    public static void main(String[] args) throws UnsupportedEncodingException, IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "chcp 65001").inheritIO();
        pb.start().waitFor();
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                calculateSum();
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Chương trình đã kết thúc.");
    }
}