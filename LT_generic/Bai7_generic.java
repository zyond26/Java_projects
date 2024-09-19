package LT_generic;
/*Bài tập 7.
Hãy viết một chương trình Java sử dụng interface generic để mô tả một cấu trúc có thể so sánh các đối tượng.
 Thực hiện các bước sau:
Tạo một interface generic tên là SoSanh<T> với phương thức:
int soSanh(T o1, T o2): trả về 1 nếu o1 lớn hơn o2, -1 nếu o1 nhỏ hơn o2, và 0 nếu bằng nhau.
Tạo một lớp HinhChuNhat với các thuộc tính:
chieudai và chieurong.
Implement SoSanh<HinhChuNhat> trong một lớp để so sánh hai hình chữ nhật dựa trên diện tích của chúng.
Trong hàm main, tạo danh sách các hình chữ nhật và sắp xếp chúng theo diện tích tăng dần. */

import java.util.ArrayList;
import java.util.List;

interface SoSanh<T> {
    int soSanh(T o1, T o2);
}

class HinhChuNhat {
    private double chieudai;
    private double chieurong;
    public HinhChuNhat(double chieudai, double chieurong) {
        this.chieudai = chieudai;
        this.chieurong = chieurong;
    }

    public double dienTich() {
        return chieudai * chieurong;
    }

    @Override
    public String toString() {
        return "HinhChuNhat{" + "chieudai=" + chieudai + ", chieurong=" + chieurong + '}';
    }
}

class SoSanhDienTich implements SoSanh<HinhChuNhat> {
    @Override
    public int soSanh(HinhChuNhat h1, HinhChuNhat h2) {
        return Double.compare(h1.dienTich(), h2.dienTich());
    }
}

public class Bai7_generic {
    public static void main(String[] args) {
        List<HinhChuNhat> danhSach = new ArrayList<>();
        danhSach.add(new HinhChuNhat(3, 4));
        danhSach.add(new HinhChuNhat(5, 6));
        danhSach.add(new HinhChuNhat(2, 3));

        SoSanh<HinhChuNhat> soSanh = new SoSanhDienTich();

        danhSach.sort((h1, h2) -> soSanh.soSanh(h1, h2));

        for (HinhChuNhat hinh : danhSach) {
            System.out.println(hinh);
        }
    }
}