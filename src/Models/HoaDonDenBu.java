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
public class HoaDonDenBu {

    private long id;
    private String nguoiMuon;
    private String nguoiXuLy;
    private float tongTien;
    private String qr_code;
    private Date ngayTao;

    public HoaDonDenBu() {
    }

    public HoaDonDenBu(long id, String nguoiMuon, String nguoiXuLy, float tongTien, String qr_code, Date ngayTao) {
        this.id = id;
        this.nguoiMuon = nguoiMuon;
        this.nguoiXuLy = nguoiXuLy;
        this.tongTien = tongTien;
        this.qr_code = qr_code;
        this.ngayTao = ngayTao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNguoiMuon() {
        return nguoiMuon;
    }

    public void setNguoiMuon(String nguoiMuon) {
        this.nguoiMuon = nguoiMuon;
    }

    public String getNguoiXuLy() {
        return nguoiXuLy;
    }

    public void setNguoiXuLy(String nguoiXuLy) {
        this.nguoiXuLy = nguoiXuLy;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public String getQr_code() {
        return qr_code;
    }

    public void setQr_code(String qr_code) {
        this.qr_code = qr_code;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    @Override
    public String toString() {
        return "HoaDonDenBu{" + "id=" + id + ", nguoiMuon=" + nguoiMuon + ", nguoiXuLy=" + nguoiXuLy + ", tongTien=" + tongTien + ", qr_code=" + qr_code + ", ngayTao=" + ngayTao + '}';
    }

}
