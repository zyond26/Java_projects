package FP_lambda;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/*Bài tập 37: FP.Lambda.4 FP duyệt 1 mảng
+Viết các hàm static nhapSoNguyenDuong nhập vào 1 số nguyên dương, nhập sai thì nhập lại.
+Viết các hàm static nhapSoNguyen nhập vào 1 số nguyên dương, nhập sai thì nhập lại.
+Viết hàm static nhapMangSoNguyen nhập vào 1 mảng số nguyên với số phần tử n cho trước, nhập sai thì nhập lại.

Gọi các hàm:
+Trong hàm main() gọi hàm  nhapSoNguyenDuong để nhận giá trị n, gọi hàm nhapMangSoNguyen(n) để nhận 1 mảng a gồm n số nguyên.
Chuyển kiểu sang stream:
+Chuyển mảng a thành đối tượng stream là i_stream  sử dụng hàm chuẩn Arrays.stream của gói java.util.Arrays;

Biểu thức lambda theo 02 cách:
+Viết biểu thức lambda để duyệt stream i_stream theo item và in ra các item.
+Viết biểu thức lambda để duyệt stream i_stream theochỉ số i và in ra các item thứu i cùng chỉ số i. */

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class bai37 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws UnsupportedEncodingException, IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "chcp 65001").inheritIO();
        pb.start().waitFor();
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        int n = nhapSoNguyenDuong();
        int[] arr = nhapMangSoNguyen(n);
        IntStream i_stream = Arrays.stream(arr);
        System.out.println("Duyệt và in từng phần tử của mảng:");
        i_stream.forEach(item -> System.out.println("Item: " + item));

        System.out.println("Duyệt theo chỉ số và in từng phần tử cùng với chỉ số:");
        IntStream.range(0, arr.length).forEach(i -> System.out.println("Phần tử thứ " + i + " là: " + arr[i]));
    }

    public static int nhapSoNguyenDuong() {
        int n = 0;
        while (true) {
            try {
                System.out.print("Nhập một số nguyên dương: ");
                n = Integer.parseInt(scanner.nextLine());
                if (n > 0)
                    return n;
                else
                    System.out.println("invalid. Please enter again");
            } catch (NumberFormatException e) {
                System.out.println("format invalid. Vui lòng nhập lại.");
            }
        }
    }

    public static int[] nhapMangSoNguyen(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            arr[i] = nhapSoNguyen();
        }
        return arr;
    }

    public static int nhapSoNguyen() {
        int num;
        while (true) {
            try {
                num = Integer.parseInt(scanner.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.println("format invalid. Vui lòng nhập lại.");
            }
        }
    }
}
