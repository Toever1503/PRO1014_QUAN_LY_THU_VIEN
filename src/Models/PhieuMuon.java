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
    private HoiVien nguoiMuon;
    private QuanLy nguoiXuLy;
    private Date ngayMuon;
    private Date hanTra;
    private String qr_code;
    private List<PhieuMuonChiTiet> listPhieuMuonChiTiet;

    public PhieuMuon() {
    }
    public PhieuMuon(Long id) {
        this.id = id;
    }

    public PhieuMuon(long id, HoiVien nguoiMuon, QuanLy nguoiXuLy, Date ngayMuon, Date hanTra, String qr_code, List<PhieuMuonChiTiet> listPhieuMuonChiTiet) {
        this.id = id;
        this.nguoiMuon = nguoiMuon;
        this.nguoiXuLy = nguoiXuLy;
        this.ngayMuon = ngayMuon;
        this.hanTra = hanTra;
        this.qr_code = qr_code;
        this.listPhieuMuonChiTiet = listPhieuMuonChiTiet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HoiVien getNguoiMuon() {
        return nguoiMuon;
    }

    public void setNguoiMuon(HoiVien nguoiMuon) {
        this.nguoiMuon = nguoiMuon;
    }

    public QuanLy getNguoiXuLy() {
        return nguoiXuLy;
    }

    public void setNguoiXuLy(QuanLy nguoiXuLy) {
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

    public List<PhieuMuonChiTiet> getListPhieuMuonChiTiet() {
        return listPhieuMuonChiTiet;
    }

    public void setListPhieuMuonChiTiet(List<PhieuMuonChiTiet> listPhieuMuonChiTiet) {
        this.listPhieuMuonChiTiet = listPhieuMuonChiTiet;
    }

}
