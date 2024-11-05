package de_so_2;

import java.util.HashMap;
import java.util.Scanner;

// Interface Command
interface Command {
    void execute();
}

// Lớp HienThiNVDuAnCmd
class HienThiNVDuAnCmd implements Command {
    private QLNV qlnv;

    public HienThiNVDuAnCmd(QLNV qlnv) {
        this.qlnv = qlnv;
    }

    @Override
    public void execute() {
        System.out.println("Danh sach nhan vien du an:");
        qlnv.getDsNV().values().stream()
                .filter(nv -> nv.getCachTra().equals("duan"))
                .forEach(nv -> System.out.println(nv.getHoTen()));
    }
}

// Lớp HienThiNVSapXepLuongCmd
class HienThiNVSapXepLuongCmd implements Command {
    private QLNV qlnv;

    public HienThiNVSapXepLuongCmd(QLNV qlnv) {
        this.qlnv = qlnv;
    }

    @Override
    public void execute() {
        System.out.println("Danh sach nhan vien sap xep theo luong:");
        qlnv.getDsNV().values().stream()
                .sorted((nv1, nv2) -> Double.compare(nv1.getLuongKhoiDiem(), nv2.getLuongKhoiDiem()))
                .forEach(nv -> System.out.println(nv.getHoTen() + " - Luong: " + nv.getLuongKhoiDiem()));
    }
}

// Lớp XuLyLenh
class XuLyLenh {
    private QLNV qlnv;

    public XuLyLenh(QLNV qlnv) {
        this.qlnv = qlnv;
    }

    public void thucThiLenh(String lenh) {
        Command command = null;
        switch (lenh) {
            case "1":
                command = new HienThiNVDuAnCmd(qlnv);
                break;
            case "2":
                command = new HienThiNVSapXepLuongCmd(qlnv);
                break;
            default:
                System.out.println("Lenh khong hop le.");
                return;
        }
        command.execute();
    }
}

// Phần main để chạy chương trình
public class CommandPattern {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        QLNV qlnv = QLNV.getInstance();
        HashMap<String, NV> dsNV = NV.nhapDSNV();

        // Đăng ký observer
        qlnv.dangKyObserver(new ThongBaoHR());
        qlnv.dangKyObserver(new ThongBaoPM());

        // Thêm nhân viên vào danh sách
        for (NV nv : dsNV.values()) {
            qlnv.themNhanVien(nv);
        }

        // Xử lý lệnh
        XuLyLenh xuLyLenh = new XuLyLenh(qlnv);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap lenh (1: Hien thi NV du an, 2: Hien thi NV sap xep luong): ");
        String lenh = scanner.nextLine();
        xuLyLenh.thucThiLenh(lenh);
    }
}