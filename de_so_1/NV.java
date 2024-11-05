package de_so_1;

import java.time.LocalDate;
import java.util.Scanner;

public class NV {
    private String maNV;
    private String hoTen;
    @SuppressWarnings("unused")
    private LocalDate ngayVaoLam;
    private double luongKhoiDiem;
    private String cachTra;

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

    public double getLuongKhoiDiem() {
        return luongKhoiDiem;
    }

    public String getCachTra() {
        return cachTra;
    }

    public static NV nhapThongTinNhanVien(Scanner scanner) {
        try {
            System.out.print("Nhập mã NV (hoặc '#' để kết thúc): ");
            String maNV = scanner.nextLine();
            if (maNV.equals("#")) {
                return null;
            }

            System.out.print("Nhập họ tên nhân viên: ");
            String hoTen = scanner.nextLine();

            System.out.print("Nhập ngày vào làm (yyyy-mm-dd): ");
            LocalDate ngayVaoLam = LocalDate.parse(scanner.nextLine());

            System.out.print("Nhập lương khởi điểm: ");
            double luongKhoiDiem = Double.parseDouble(scanner.nextLine());

            System.out.print("Nhập cách trả lương (duan/ngay): ");
            String cachTra = scanner.nextLine();
            if (!cachTra.equals("duan") && !cachTra.equals("ngay")) {
                throw new IllegalArgumentException("Cách trả lương phải là 'duan' hoặc 'ngay'");
            }

            return new NV(maNV, hoTen, ngayVaoLam, luongKhoiDiem, cachTra);
        } catch (Exception e) {
            System.out.println("Dữ liệu nhập không hợp lệ: " + e.getMessage());
            return null;
        }
    }

}
