package de_so_3;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException, IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "chcp 65001").inheritIO();
        pb.start().waitFor();
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        QLNV qlnv = QLNV.getInstance();

        HashMap<String, NV> dsNV = NV.nhapNhanVien();
        qlnv.setDsNV(dsNV);

        qlnv.themQuanSat(new ThongBaoHR());
        qlnv.themQuanSat(new ThongBaoPM());

        for (NV nv : dsNV.values()) {
            qlnv.themNhanVien(nv);
        }

        qlnv.tinhLuongChoTatCa();
    }
}
