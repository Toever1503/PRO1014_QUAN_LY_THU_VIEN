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
public class HoaDonNhapSach {

    private long id;
    private String nguoiXuLy;
    private float tongTien;
    private Date ngayTao;
    private String qr_code;

    public HoaDonNhapSach() {
    }

    public HoaDonNhapSach(long id, String nguoiXuLy, float tongTien, Date ngayTao, String qr_code) {
        this.id = id;
        this.nguoiXuLy = nguoiXuLy;
        this.tongTien = tongTien;
        this.ngayTao = ngayTao;
        this.qr_code = qr_code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "HoaDonNhapSach{" + "id=" + id + ", nguoiXuLy=" + nguoiXuLy + ", tongTien=" + tongTien + ", ngayTao=" + ngayTao + ", qr_code=" + qr_code + '}';
    }
}
