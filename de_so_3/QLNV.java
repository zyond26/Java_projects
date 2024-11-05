package de_so_3;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class QLNV {
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

    public void themQuanSat(QuanSat qs) {
        dsQS.add(qs);
    }

    public void themNhanVien(NV nv) {
        dsNV.put(nv.maNV, nv);
        for (QuanSat qs : dsQS) {
            if (nv.cachTra.equals("duan") && qs instanceof ThongBaoPM) {
                qs.capNhat(nv.maNV, nv);
            } else if (nv.cachTra.equals("ngay") && qs instanceof ThongBaoHR) {
                qs.capNhat(nv.maNV, nv);
            }
        }
    }

    public void tinhLuongChoTatCa() {
        new Thread(() -> {
            for (NV nv : dsNV.values()) {
                double luong = nv.tinhLuong();
                System.out.println("Lương của nhân viên " + nv.hoTen + " (Mã: " + nv.maNV + ") là: " + luong);
            }
        }).start();
    }

    public HashMap<String, NV> getDsNV() {
        return dsNV;
    }

    public void setDsNV(HashMap<String, NV> dsNV) {
        this.dsNV = dsNV;
    }
}

interface QuanSat {
    void capNhat(String maNV, NV nv);
}

class ThongBaoHR implements QuanSat {
    @Override
    public void capNhat(String maNV, NV nv) {
        System.out.println("Thông báo HR: Nhân viên mới - " + nv.hoTen + " (Mã: " + maNV + ")");
    }
}

class ThongBaoPM implements QuanSat {
    @Override
    public void capNhat(String maNV, NV nv) {
        System.out.println("Thông báo PM: Nhân viên mới - " + nv.hoTen + " (Mã: " + maNV + ")");
    }
}
