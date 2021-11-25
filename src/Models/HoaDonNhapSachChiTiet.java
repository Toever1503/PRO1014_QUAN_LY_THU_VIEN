/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author haunv
 */
public class HoaDonNhapSachChiTiet {

    private Long hoaDonNhap;
    private Sach sach;
    private Double gia;
    private int soLuong;
    private boolean loaiSach;

    public HoaDonNhapSachChiTiet() {
    }

    public HoaDonNhapSachChiTiet(Long hoaDonNhap, Sach sach, Double gia, int soLuong, boolean loaiSach) {
        this.hoaDonNhap = hoaDonNhap;
        this.sach = sach;
        this.gia = gia;
        this.soLuong = soLuong;
        this.loaiSach = loaiSach;
    }

    public Long getHoaDonNhap() {
        return hoaDonNhap;
    }

    public void setHoaDonNhap(Long hoaDonNhap) {
        this.hoaDonNhap = hoaDonNhap;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public boolean isLoaiSach() {
        return loaiSach;
    }

    public void setLoaiSach(boolean loaiSach) {
        this.loaiSach = loaiSach;
    }

    @Override
    public String toString() {
        return "HoaDonNhapSachChiTiet{" + "hoaDonNhap=" + hoaDonNhap + ", sach=" + sach + ", gia=" + gia + ", soLuong=" + soLuong + ", loaiSach=" + loaiSach + '}';
    }

}
