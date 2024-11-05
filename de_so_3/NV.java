package de_so_3;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Scanner;

public class NV {
    String maNV;
    String hoTen;
    LocalDate ngayVaoLam;
    double luongKhoiDiem;
    String cachTra;
    TinhLuong tinhLuongStrategy;

    public NV(String maNV, String hoTen, LocalDate ngayVaoLam, double luongKhoiDiem, String cachTra) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngayVaoLam = ngayVaoLam;
        this.luongKhoiDiem = luongKhoiDiem;
        this.cachTra = cachTra;

        if (cachTra.equals("duan")) {
            this.tinhLuongStrategy = new TinhLuongDuAn();
        } else if (cachTra.equals("ngay")) {
            this.tinhLuongStrategy = new TinhLuongNgay();
        }
    }

    public double tinhLuong() {
        return tinhLuongStrategy.tinhLuong(this.luongKhoiDiem);
    }

    public static HashMap<String, NV> nhapNhanVien() {
        HashMap<String, NV> dsNV = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Nhập mã nhân viên (nhập # để dừng): ");
                String maNV = scanner.nextLine();
                if (maNV.equals("#"))
                    break;

                System.out.print("Nhập họ tên nhân viên: ");
                String hoTen = scanner.nextLine();

                System.out.print("Nhập ngày vào làm (yyyy-MM-dd): ");
                LocalDate ngayVaoLam = LocalDate.parse(scanner.nextLine());

                System.out.print("Nhập lương khởi điểm: ");
                double luongKhoiDiem = Double.parseDouble(scanner.nextLine());

                System.out.print("Nhập cách trả lương (duan/ngay): ");
                String cachTra = scanner.nextLine();
                if (!cachTra.equals("duan") && !cachTra.equals("ngay")) {
                    throw new IllegalArgumentException("Cách trả lương không hợp lệ!");
                }

                NV nv = new NV(maNV, hoTen, ngayVaoLam, luongKhoiDiem, cachTra);
                dsNV.put(maNV, nv);

            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Lương phải là số.");
            } catch (DateTimeParseException e) {
                System.out.println("Lỗi: Ngày vào làm không hợp lệ.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
        return dsNV;
    }
}

interface TinhLuong {
    double tinhLuong(double luongKhoiDiem);
}

class TinhLuongDuAn implements TinhLuong {
    @Override
    public double tinhLuong(double luongKhoiDiem) {
        return luongKhoiDiem * 1.5;
    }
}

class TinhLuongNgay implements TinhLuong {
    @Override
    public double tinhLuong(double luongKhoiDiem) {
        return luongKhoiDiem / 22;
    }
}
