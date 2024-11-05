package BaiTapppppp;

/*Bài tập 9. 
Hãy viết một chương trình Java sử dụng TreeMap (TreeMap phù hợp trong các tình huống cần duy trì thứ tự sắp
 xếp của các key) để quản lý danh sách sinh viên và điểm số của sinh viên. Thực hiện các bước sau:
Tạo một TreeMap để lưu trữ thông tin:
Key là tên sinh viên (kiểu String).
Value là điểm số của sinh viên (kiểu Integer).
Thêm một số sinh viên vào TreeMap.
In ra danh sách sinh viên được sắp xếp theo tên (thứ tự mặc định của TreeMap).
In ra điểm số của một sinh viên cụ thể. */

import java.util.TreeMap;

public class Bai9_treemap {
    public static void main(String[] args) {
        TreeMap<String, Integer> diemSinhVien = new TreeMap<>();

        // Thêm sinh viên và điểm số vào TreeMap
        diemSinhVien.put("An", 85);
        diemSinhVien.put("Bach", 90);
        diemSinhVien.put("Dieu", 75);

        // In ra danh sách sinh viên theo thứ tự tên
        System.out.println("Danh sach sinh vien:");
        for (String ten : diemSinhVien.keySet()) {
            System.out.println("Ten: " + ten + ", Diem: " + diemSinhVien.get(ten));
        }

        // In ra điểm số của một sinh viên cụ thể
        String sv = "Binh";
        System.out.println("Diem cua " + sv + ": " + diemSinhVien.get(sv));
    }
}