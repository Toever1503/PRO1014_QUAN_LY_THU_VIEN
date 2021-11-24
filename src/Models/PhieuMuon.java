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
public class PhieuMuon {
    private BigInteger id;
    private BigInteger nguoiMuon;
    private String nguoiXuLy;
    private Date ngayMuon;
    private Date hanTra;
    private String qr_code;

    public PhieuMuon(BigInteger id, BigInteger nguoiMuon, String nguoiXuLy, Date ngayMuon, Date hanTra, String qr_code) {
        this.id = id;
        this.nguoiMuon = nguoiMuon;
        this.nguoiXuLy = nguoiXuLy;
        this.ngayMuon = ngayMuon;
        this.hanTra = hanTra;
        this.qr_code = qr_code;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getNguoiMuon() {
        return nguoiMuon;
    }

    public void setNguoiMuon(BigInteger nguoiMuon) {
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

    @Override
    public String toString() {
        return "PhieuMuon{" + "id=" + id + ", nguoiMuon=" + nguoiMuon + ", nguoiXuLy=" + nguoiXuLy + ", ngayMuon=" + ngayMuon + ", hanTra=" + hanTra + ", qr_code=" + qr_code + '}';
    }
    
    
}
