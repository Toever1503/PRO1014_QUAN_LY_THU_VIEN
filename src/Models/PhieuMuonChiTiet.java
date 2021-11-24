/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.math.BigInteger;
import java.sql.Date;
/**
 *
 * @author haunv
 */
public class PhieuMuonChiTiet {
    private BigInteger phieuMuon;
    private BigInteger sach;
    private String nguoiXuLy;
    private Date ngayTra;
    private boolean trangThai;

    public PhieuMuonChiTiet(BigInteger phieuMuon, BigInteger sach, String nguoiXuLy, Date ngayTra, boolean trangThai) {
        this.phieuMuon = phieuMuon;
        this.sach = sach;
        this.nguoiXuLy = nguoiXuLy;
        this.ngayTra = ngayTra;
        this.trangThai = trangThai;
    }

    public BigInteger getPhieuMuon() {
        return phieuMuon;
    }

    public void setPhieuMuon(BigInteger phieuMuon) {
        this.phieuMuon = phieuMuon;
    }

    public BigInteger getSach() {
        return sach;
    }

    public void setSach(BigInteger sach) {
        this.sach = sach;
    }

    public String getNguoiXuLy() {
        return nguoiXuLy;
    }

    public void setNguoiXuLy(String nguoiXuLy) {
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
