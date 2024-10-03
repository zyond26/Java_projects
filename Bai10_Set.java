/*Bài tập 10.
Hãy viết một chương trình Java sử dụng Set để quản lý một danh sách các sinh viên duy nhất. 
Thực hiện các bước sau:

Tạo một HashSet (HashSet không duy trì thứ tự của các phần tử.để lưu trữ tên sinh viên (kiểu String).
Thêm một số tên sinh viên vào Set. Chú ý thêm một số tên trùng lặp để kiểm tra tính duy nhất.
In ra danh sách các sinh viên, đảm bảo không có tên nào bị trùng.
Kiểm tra xem một sinh viên cụ thể có trong Set hay không và in kết quả. */

import java.util.HashSet;
import java.util.Set;

public class Bai10_Set {
    public static void main(String[] args) {
        Set<String> danhSachSinhVien = new HashSet<>();

        // Thêm tên sinh viên vào Set
        danhSachSinhVien.add("An");
        danhSachSinhVien.add("Binh");
        danhSachSinhVien.add("An"); // Tên trùng lặp

        // In ra danh sách sinh viên
        System.out.println("Danh sach sinh vien:");
        for (String ten : danhSachSinhVien) {
            System.out.println(ten);
        }

        // Kiểm tra sự tồn tại của một sinh viên cụ thể
        String sv = "Binh";
        if (danhSachSinhVien.contains(sv)) {
            System.out.println(sv + " co trong danh sach.");
        } else {
            System.out.println(sv + " khong co trong danh sach.");
        }
    }
}
