package de_so_1;

public class ThongBaoHR implements QuanSat {
    @Override
    public void capNhat(String message, NV nv) {
        System.out.println("HR nhận thông báo: " + message + " cho nhân viên: " + nv.getMaNV());
    }
}
