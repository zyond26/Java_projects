package de_so_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QLNV {
    private static QLNV instance;
    private HashMap<String, NV> dsNV = new HashMap<>();
    private List<QuanSat> dsQS = new ArrayList<>();

    private QLNV() {
    }

    public static QLNV getInstance() {
        if (instance == null) {
            instance = new QLNV();
        }
        return instance;
    }

    public void themNhanVien(NV nv) {
        dsNV.put(nv.getMaNV(), nv);

        for (QuanSat qs : dsQS) {
            if (nv.getCachTra().equals("duan") && qs instanceof ThongBaoPM) {
                qs.capNhat("duan", nv);
            } else if (nv.getCachTra().equals("ngay") && qs instanceof ThongBaoHR) {
                qs.capNhat("ngay", nv);
            }
        }
    }

    public void themQuanSat(QuanSat qs) {
        dsQS.add(qs);
    }

    public HashMap<String, NV> getDsNV() {
        return dsNV;
    }
}
