package BaiTapppppp;

/*Luyện tập về Collections

Bài tập 8.
Hãy viết một chương trình Java sử dụng HashMap để quản lý thông tin sản phẩm và giá của chúng. Thực hiện các bước sau:

Tạo một HashMap để lưu trữ:
Key là tên sản phẩm (kiểu String).
Value là giá sản phẩm (kiểu Double).
Thêm một số sản phẩm vào HashMap.
In ra danh sách tất cả sản phẩm và giá tương ứng.
Tìm và in giá của một sản phẩm cụ thể. */
import java.util.HashMap;

public class Bai8_collection {
    public static void main(String[] args) {
        HashMap<String, Double> giaSanPham = new HashMap<>();

        // Thêm sản phẩm và giá vào HashMap
        giaSanPham.put("Ban", 1500.0);
        giaSanPham.put("Ghe", 300.0);
        giaSanPham.put("Den", 250.0);

        // In ra danh sách sản phẩm và giá
        System.out.println("Danh sach san pham:");
        for (String ten : giaSanPham.keySet()) {
            System.out.println("San pham: " + ten + ", Gia: " + giaSanPham.get(ten));
        }

        // In ra giá của một sản phẩm cụ thể
        String hh = "Ghe";
        System.out.println("Gia cua " + hh + ": " + giaSanPham.get(hh));
    }
}
