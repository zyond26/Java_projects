package de_so_2;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

// Lớp NV đại diện cho nhân viên
class NV {
    private String maNV;
    private String hoTen;
    private LocalDate ngayVaoLam;
    private double luongKhoiDiem;
    private String cachTra;

    // Constructor
    public NV(String maNV, String hoTen, LocalDate ngayVaoLam, double luongKhoiDiem, String cachTra) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngayVaoLam = ngayVaoLam;
        this.luongKhoiDiem = luongKhoiDiem;
        this.cachTra = cachTra;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public LocalDate getNgayVaoLam() {
        return ngayVaoLam;
    }

    public double getLuongKhoiDiem() {
        return luongKhoiDiem;
    }

    public String getCachTra() {
        return cachTra;
    }

    // Phương thức tĩnh để nhập danh sách nhân viên
    public static HashMap<String, NV> nhapDSNV() {
        HashMap<String, NV> dsNV = new HashMap<>();
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Nhap ma nhan vien (hoac # de dung): ");
            String maNV = scanner.nextLine();
            if (maNV.equals("#"))
                break;

            try {
                System.out.print("Nhap ho ten nhan vien: ");
                String hoTen = scanner.nextLine();

                System.out.print("Nhap ngay vao lam (yyyy-MM-dd): ");
                LocalDate ngayVaoLam = LocalDate.parse(scanner.nextLine());

                System.out.print("Nhap luong khoi diem: ");
                double luongKhoiDiem = Double.parseDouble(scanner.nextLine());

                System.out.print("Nhap cach tra (duan/ngay): ");
                String cachTra = scanner.nextLine();
                if (!cachTra.equals("duan") && !cachTra.equals("ngay")) {
                    throw new IllegalArgumentException("Cach tra khong hop le!");
                }

                NV nv = new NV(maNV, hoTen, ngayVaoLam, luongKhoiDiem, cachTra);
                dsNV.put(maNV, nv);
            } catch (Exception e) {
                System.out.println("Loi: " + e.getMessage());
            }
        }
        return dsNV;
    }

    public static void main(String[] args) {
        HashMap<String, NV> dsNV = NV.nhapDSNV();
        // In ra danh sach nhan vien da nhap
        dsNV.forEach((k, v) -> System.out.println(k + ": " + v.getHoTen()));
    }
}

// Lớp QLNV theo mẫu Singleton
class QLNV {
    private static QLNV instance;
    private HashMap<String, NV> dsNV;
    private List<QuanSat> dsQS;

    private QLNV() {
        dsNV = new HashMap<>();
        dsQS = new ArrayList<>();
    }

    public static QLNV getInstance() {
        if (instance == null) {
            instance = new QLNV();
        }
        return instance;
    }

    public void themNhanVien(NV nv) {
        dsNV.put(nv.getMaNV(), nv);
        capNhatObserver(nv);
    }

    public void dangKyObserver(QuanSat observer) {
        dsQS.add(observer);
    }

    private void capNhatObserver(NV nv) {
        for (QuanSat observer : dsQS) {
            if (nv.getCachTra().equals("duan")) {
                observer.capNhat("Co nhan vien moi: " + nv.getHoTen(), nv);
            } else if (nv.getCachTra().equals("ngay")) {
                observer.capNhat("Co nhan vien moi: " + nv.getHoTen(), nv);
            }
        }
    }

    // Phương thức để lấy danh sách nhân viên
    public HashMap<String, NV> getDsNV() {
        return dsNV;
    }
}

// Interface QuanSat
interface QuanSat {
    void capNhat(String message, NV nv);
}

// Lớp ThongBaoHR
class ThongBaoHR implements QuanSat {
    @Override
    public void capNhat(String message, NV nv) {
        System.out.println("Thong bao cho phong HR: " + message);
    }
}

// Lớp ThongBaoPM
class ThongBaoPM implements QuanSat {
    @Override
    public void capNhat(String message, NV nv) {
        System.out.println("Thong bao cho doi du an: " + message);
    }
}