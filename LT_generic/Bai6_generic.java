package LT_generic;
/*Bài tập 6.

Hãy viết một chương trình Java có một phương thức generic để in ra các phần tử của một mảng. 
Thực hiện các bước sau:
Tạo một lớp có tên HoTro.
Trong lớp HoTro, viết một phương thức generic inMang có thể in ra các phần tử của bất kỳ loại mảng nào.
Trong hàm main, sử dụng phương thức inMang để in ra:
Một mảng số nguyên.
Một mảng chuỗi.
 */

class HoTro {
    public static <T> void inMang(T[] mang) {
        for (T phanTu : mang) {
            System.out.print(phanTu + " ");
        }
        System.out.println();
    }
}

public class Bai6_generic {
    public static void main(String[] args) {
        Integer[] mangsoNguyen = { 1, 2, 3, 4, 5, 6 };
        String[] mangChuoi = { "Xin", "Chao" };
        HoTro.inMang(mangsoNguyen);
        HoTro.inMang(mangChuoi);
    }

}
