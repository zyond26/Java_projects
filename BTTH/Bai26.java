package BTTH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Observer interface
interface NhaDauTu {
    void capNhatGiaCoPhieu(String maCoPhieu, double gia);
}

// Singleton Subject class
class DichVuChungKhoan {
    private static DichVuChungKhoan instance;
    private List<NhaDauTu> danhSachNhaDauTu;
    private Map<String, Double> giaCoPhieu;

    private DichVuChungKhoan() {
        danhSachNhaDauTu = new ArrayList<>();
        giaCoPhieu = new HashMap<>();
    }

    public static DichVuChungKhoan getInstance() {
        if (instance == null) {
            instance = new DichVuChungKhoan();
        }
        return instance;
    }

    public void dangKy(NhaDauTu nhaDauTu) {
        danhSachNhaDauTu.add(nhaDauTu);
    }

    public void huyDangKy(NhaDauTu nhaDauTu) {
        danhSachNhaDauTu.remove(nhaDauTu);
    }

    public void capNhatGia(String maCoPhieu, double giaMoi) {
        giaCoPhieu.put(maCoPhieu, giaMoi);
        thongBaoCapNhat(maCoPhieu, giaMoi);
    }

    private void thongBaoCapNhat(String maCoPhieu, double gia) {
        for (NhaDauTu nhaDauTu : danhSachNhaDauTu) {
            nhaDauTu.capNhatGiaCoPhieu(maCoPhieu, gia);
        }
    }
}

// Concrete Observer class: cụ thể hóa
class NhaDauTuCaNhan implements NhaDauTu {
    private String ten;

    public NhaDauTuCaNhan(String ten) {
        this.ten = ten;
    }

    @Override
    public void capNhatGiaCoPhieu(String maCoPhieu, double gia) {
        System.out.printf("%s nhận được cập nhật: Cổ phiếu %s có giá mới là %.2f\n", ten, maCoPhieu, gia);
    }
}

// Main class để chạy demo
public class Bai26 {
    public static void main(String[] args) {
        DichVuChungKhoan dichVu = DichVuChungKhoan.getInstance();

        NhaDauTuCaNhan nhaDauTu1 = new NhaDauTuCaNhan("Nguyễn Văn A");
        NhaDauTuCaNhan nhaDauTu2 = new NhaDauTuCaNhan("Trần Thị B");

        dichVu.dangKy(nhaDauTu1);
        dichVu.dangKy(nhaDauTu2);

        dichVu.capNhatGia("VNM", 80.5);
        dichVu.capNhatGia("FPT", 75.2);

        dichVu.huyDangKy(nhaDauTu1);

        dichVu.capNhatGia("VNM", 81.0);
    }
}