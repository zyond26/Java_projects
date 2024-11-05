package FP_lambda;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/*Bài tập 34: FP.Lambda.1
Viết một chương trình Java sử dụng biểu thức lambda để tính bình phương của một số.

Tạo một functional interface có tên là SquareCalculator với một phương thức abstract calculate(int n)
 trả về một số nguyên.
Trong phương thức main, sử dụng biểu thức lambda để implement interface SquareCalculator.
Nhập vào số nguyên n từ bàn phím, sử dụng implementation này để tính và in ra bình phương của n. */

interface SquareCalculator {
    int calculate(int n);
}

public class bai34 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws UnsupportedEncodingException, IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "chcp 65001").inheritIO();
        pb.start().waitFor();
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        // Biểu thức lambda cài đặt interface
        SquareCalculator square = n -> n * n;
        System.out.print("Nhập một số nguyên dương: ");
        int n = nhapSoNguyenDuong();

        // Sử dụng interface lambda để tính bình phương của n
        int result = square.calculate(n);
        System.out.println("Bình phương của " + n + " là: " + result);
        scanner.close();
    }

    public static int nhapSoNguyenDuong() {
        int n = 0;
        while (true) {
            try {
                n = Integer.parseInt(scanner.nextLine());
                if (n > 0)
                    return n;
                else
                    System.out.println("invalid. Please enter again");
            } catch (NumberFormatException e) {
                System.out.println(e + ":" + "...");
            }
        }
    }
}