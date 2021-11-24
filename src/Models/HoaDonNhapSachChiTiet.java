/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.math.BigInteger;

/**
 *
 * @author haunv
 */
public class HoaDonNhapSachChiTiet {

    private BigInteger hoaDonNhap;
    private BigInteger sach;
    private float gia;
    private int soLuong;
    private boolean loaiSach;

    public HoaDonNhapSachChiTiet() {
    }

    public HoaDonNhapSachChiTiet(BigInteger hoaDonNhap, BigInteger sach, float gia, int soLuong, boolean loaiSach) {
        this.hoaDonNhap = hoaDonNhap;
        this.sach = sach;
        this.gia = gia;
        this.soLuong = soLuong;
        this.loaiSach = loaiSach;
    }

    public BigInteger getHoaDonNhap() {
        return hoaDonNhap;
    }

    public void setHoaDonNhap(BigInteger hoaDonNhap) {
        this.hoaDonNhap = hoaDonNhap;
    }

    public BigInteger getSach() {
        return sach;
    }

    public void setSach(BigInteger sach) {
        this.sach = sach;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
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
