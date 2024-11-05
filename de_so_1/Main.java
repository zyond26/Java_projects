package de_so_1;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException, IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "chcp 65001").inheritIO();
        pb.start().waitFor();
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        Scanner scanner = new Scanner(System.in);
        HashMap<String, NV> dsNV = new HashMap<>();

        while (true) {
            NV nv = NV.nhapThongTinNhanVien(scanner);
            if (nv == null) {
                break;
            }
            dsNV.put(nv.getMaNV(), nv);
        }

        CompletableFuture.supplyAsync(() -> sapXepTheoLuongKhoiDiem(dsNV))
                .thenApply(danhSach -> {
                    hienThiDanhSachNhanVien(danhSach);
                    return danhSach;
                })
                .thenAccept(danhSach -> System.out.println("Hoàn thành xử lý các thao tác bất đồng bộ!"));

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static List<NV> sapXepTheoLuongKhoiDiem(HashMap<String, NV> dsNV) {
        List<NV> sortedList = dsNV.values().stream()
                .sorted((nv1, nv2) -> Double.compare(nv1.getLuongKhoiDiem(), nv2.getLuongKhoiDiem()))
                .collect(Collectors.toList());

        try {
            TimeUnit.SECONDS.sleep(1); // Delay 1 giây
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hàm sapXepTheoLuongKhoiDiem thực hiện xong.");
        return sortedList;
    }

    public static void hienThiDanhSachNhanVien(List<NV> danhSach) {
        System.out.println("Danh sách nhân viên sau khi sắp xếp theo lương khởi điểm:");
        danhSach.forEach(nv -> System.out.println("Mã NV: " + nv.getMaNV() + ", Họ tên: " + nv.getHoTen()
                + ", Lương khởi điểm: " + nv.getLuongKhoiDiem()));

        try {
            TimeUnit.SECONDS.sleep(2); // Delay 2 giây
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hàm hienThiDanhSachNhanVien thực hiện xong.");
    }
}
