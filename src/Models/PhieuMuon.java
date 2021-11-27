/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author haunv
 */
public class PhieuMuon {

    private Long id;
    private Long nguoiMuon;
    private String nguoiXuLy;
    private Date ngayMuon;
    private Date hanTra;
    private String qr_code;
    List<PhieuMuonChiTiet> listPhieuMuonChiTiets;

    public PhieuMuon() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getNguoiMuon() {
        return nguoiMuon;
    }

    public void setNguoiMuon(Long nguoiMuon) {
        this.nguoiMuon = nguoiMuon;
    }

    public String getNguoiXuLy() {
        return nguoiXuLy;
    }

    public void setNguoiXuLy(String nguoiXuLy) {
        this.nguoiXuLy = nguoiXuLy;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Date getHanTra() {
        return hanTra;
    }

    public void setHanTra(Date hanTra) {
        this.hanTra = hanTra;
    }

    public String getQr_code() {
        return qr_code;
    }

    public void setQr_code(String qr_code) {
        this.qr_code = qr_code;
    }

    public List<PhieuMuonChiTiet> getListPhieuMuonChiTiets() {
        return listPhieuMuonChiTiets;
    }

    public void setListPhieuMuonChiTiets(List<PhieuMuonChiTiet> listPhieuMuonChiTiets) {
        this.listPhieuMuonChiTiets = listPhieuMuonChiTiets;
    }

    @Override
    public String toString() {
        return "PhieuMuon{" + "id=" + id + ", nguoiMuon=" + nguoiMuon + ", nguoiXuLy=" + nguoiXuLy + ", ngayMuon=" + ngayMuon + ", hanTra=" + hanTra + ", qr_code=" + qr_code + ", listPhieuMuonChiTiets=" + listPhieuMuonChiTiets + '}';
    }

}
