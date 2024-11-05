package de_so_1;

public class ThongBaoPM implements QuanSat {
    @Override
    public void capNhat(String message, NV nv) {
        System.out.println("PM nhận thông báo: " + message + " cho nhân viên: " + nv.getMaNV());
    }
}
