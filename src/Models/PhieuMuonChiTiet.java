/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Date;

/**
 *
 * @author haunv
 */
public class PhieuMuonChiTiet {

    private Long phieuMuon;
    private Sach sach;
    private QuanLy nguoiXuLy;
    private Date ngayTra;
    private boolean trangThai;

    public PhieuMuonChiTiet() {
    }
    
    public PhieuMuonChiTiet(long phieuMuon, Sach sach, QuanLy nguoiXuLy, Date ngayTra, boolean trangThai) {
        this.phieuMuon = phieuMuon;
        this.sach = sach;
        this.nguoiXuLy = nguoiXuLy;
        this.ngayTra = ngayTra;
        this.trangThai = trangThai;
    }

    public long getPhieuMuon() {
        return phieuMuon;
    }

    public void setPhieuMuon(long phieuMuon) {
        this.phieuMuon = phieuMuon;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public QuanLy getNguoiXuLy() {
        return nguoiXuLy;
    }

    public void setNguoiXuLy(QuanLy nguoiXuLy) {
        this.nguoiXuLy = nguoiXuLy;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "PhieuMuonChiTiet{" + "phieuMuon=" + phieuMuon + ", sach=" + sach + ", nguoiXuLy=" + nguoiXuLy + ", ngayTra=" + ngayTra + ", trangThai=" + trangThai + '}';
    }

}
