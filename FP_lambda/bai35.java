package FP_lambda;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/*Bài tập 35: FP.Lambda.2
Viết một chương trình Java sử dụng biểu thức lambda để tính tổng 2 số nguyên

Tạo một functional interface có tên là SumCalculator với một phương thức abstract calculate(int n) 
trả về một số nguyên.
Trong phương thức main, sử dụng biểu thức lambda để implement interface SumCalculator.
Nhập vào 2 số nguyên a,b từ bàn phím, sử dụng implementation này để  in ra tổng của a và b. */

interface SumCalculator {
    int calculate(int a, int b);
}

public class bai35 {
    public static void main(String[] args) throws UnsupportedEncodingException, IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "chcp 65001").inheritIO();
        pb.start().waitFor();
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        // biểu thức lambda cài đặt interface
        SumCalculator sum = (int a, int b) -> a + b;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nhập số nguyên a: ");
            int a = scanner.nextInt();
            System.out.print("Nhập số nguyên b: ");
            int b = scanner.nextInt();
            System.out.println("Tổng 2 số là: " + sum.calculate(a, b));
        }
    }
}
