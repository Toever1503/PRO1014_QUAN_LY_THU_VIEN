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

    private Long id;
    private String nguoiXuLy;
    private Float tongTien;
    private Date ngayTao;
    private String qr_code;

    public HoaDonNhapSach() {
    }

    public HoaDonNhapSach(Long id, String nguoiXuLy, Float tongTien, Date ngayTao, String qr_code) {
        this.id = id;
        this.nguoiXuLy = nguoiXuLy;
        this.tongTien = tongTien;
        this.ngayTao = ngayTao;
        this.qr_code = qr_code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNguoiXuLy() {
        return nguoiXuLy;
    }

    public void setNguoiXuLy(String nguoiXuLy) {
        this.nguoiXuLy = nguoiXuLy;
    }

    public Float getTongTien() {
        return tongTien;
    }

    public void setTongTien(Float tongTien) {
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
