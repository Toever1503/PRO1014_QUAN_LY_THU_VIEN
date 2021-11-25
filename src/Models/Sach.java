/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Date;

/**
 *
 * @author NguyenHoan
 */
public class Sach {

    private Long id;
    private QuanLy nguoiTao;
    private String tenSach;
    private String viTri;
    private Date ngayTao;
    private String qr_code;
    private NhaXuatBan nhaXuatBan;
    private boolean trangThai;
    private HoaDonNhapSachChiTiet hoaDonNhapSachChiTiet;

    public Sach() {
    }
    public Sach(Long id) {
        this.id=id;
    }

    public Sach(long id, QuanLy nguoiTao, String tenSach, String viTri, Date ngayTao, String qr_code, NhaXuatBan nhaXuatBan, boolean trangThai, HoaDonNhapSachChiTiet hoaDonNhapSachChiTiet) {
        this.id = id;
        this.nguoiTao = nguoiTao;
        this.tenSach = tenSach;
        this.viTri = viTri;
        this.ngayTao = ngayTao;
        this.qr_code = qr_code;
        this.nhaXuatBan = nhaXuatBan;
        this.trangThai = trangThai;
        this.hoaDonNhapSachChiTiet = hoaDonNhapSachChiTiet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public QuanLy getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(QuanLy nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getQr_code() {
        return qr_code;
    }

    public void setQr_code(String qr_code) {
        this.qr_code = qr_code;
    }

    public NhaXuatBan getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(NhaXuatBan nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public HoaDonNhapSachChiTiet getHoaDonNhapSachChiTiet() {
        return hoaDonNhapSachChiTiet;
    }

    public void setHoaDonNhapSachChiTiet(HoaDonNhapSachChiTiet hoaDonNhapSachChiTiet) {
        this.hoaDonNhapSachChiTiet = hoaDonNhapSachChiTiet;
    }

    @Override
    public String toString() {
        return "Sach{" + "id=" + id + ", nguoiTao=" + nguoiTao + ", tenSach=" + tenSach + ", viTri=" + viTri + ", ngayTao=" + ngayTao + ", qr_code=" + qr_code + ", nhaXuatBan=" + nhaXuatBan + ", trangThai=" + trangThai + ", hoaDonNhapSachChiTiet=" + hoaDonNhapSachChiTiet + '}';
    }

}
