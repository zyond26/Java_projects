package de_so_3;

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
