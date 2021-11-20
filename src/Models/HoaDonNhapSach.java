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
public class HoaDonNhapSach {
    private BigInteger id;
    private BigInteger nguoiXuLy;
    private BigInteger tongTien;
    private Date ngayTao;
    private String qr_code;

    public HoaDonNhapSach(BigInteger id, BigInteger nguoiXuLy, BigInteger tongTien, Date ngayTao, String qr_code) {
        this.id = id;
        this.nguoiXuLy = nguoiXuLy;
        this.tongTien = tongTien;
        this.ngayTao = ngayTao;
        this.qr_code = qr_code;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getNguoiXuLy() {
        return nguoiXuLy;
    }

    public void setNguoiXuLy(BigInteger nguoiXuLy) {
        this.nguoiXuLy = nguoiXuLy;
    }

    public BigInteger getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigInteger tongTien) {
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
}
